package com.omertron.thetvdbapiv2.tools;

import com.omertron.thetvdbapiv2.TvDbException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.yamj.api.common.exception.ApiExceptionType;
import org.yamj.api.common.http.DigestedResponse;
import org.yamj.api.common.http.DigestedResponseReader;

/**
 * HTTP tools to aid in processing web requests
 *
 * @author Stuart.Boston
 */
public class HttpTools {

//    private static final Logger LOG = LoggerFactory.getLogger(HttpTools.class);
    private final HttpClient httpClient;
    private static final Charset CHARSET = Charset.forName("UTF-8");
    private static final String APPLICATION_JSON = "application/json";
    private static final long RETRY_DELAY = 1;
    private static final int RETRY_MAX = 5;
    private static final int STATUS_TOO_MANY_REQUESTS = 429;

    public HttpTools(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * GET data from the URL
     *
     * @param url URL to use in the request
     * @return String content
     * @throws TvDbException
     */
    public String getRequest(final URL url) throws TvDbException {
        try {
            HttpGet httpGet = new HttpGet(url.toURI());
            httpGet.addHeader(HttpHeaders.ACCEPT, APPLICATION_JSON);
            DigestedResponse response = DigestedResponseReader.requestContent(httpClient, httpGet, CHARSET);
            long retryCount = 0L;

            // If we have a 429 response, wait and try again
            while (response.getStatusCode() == STATUS_TOO_MANY_REQUESTS && retryCount++ <= RETRY_MAX) {
                delay(retryCount);

                // Retry the request
                response = DigestedResponseReader.requestContent(httpClient, httpGet, CHARSET);
            }

            return validateResponse(response, url);
        } catch (URISyntaxException | IOException ex) {
            throw new TvDbException(ApiExceptionType.CONNECTION_ERROR, null, url, ex);
        } catch (RuntimeException ex) {
            throw new TvDbException(ApiExceptionType.HTTP_503_ERROR, "Service Unavailable", url, ex);
        }
    }

    /**
     * Sleep for a period of time
     *
     * @param multiplier
     */
    private void delay(long multiplier) {
        try {
            // Wait for the timeout to finish
            Thread.sleep(TimeUnit.SECONDS.toMillis(RETRY_DELAY * multiplier));
        } catch (InterruptedException ex) {
            // Doesn't matter if we're interrupted
        }
    }

    /**
     * Execute a DELETE on the URL
     *
     * @param url URL to use in the request
     * @return String content
     * @throws TvDbException
     */
    public String deleteRequest(final URL url) throws TvDbException {
        try {
            HttpDelete httpDel = new HttpDelete(url.toURI());
            return validateResponse(DigestedResponseReader.deleteContent(httpClient, httpDel, CHARSET), url);
        } catch (URISyntaxException | IOException ex) {
            throw new TvDbException(ApiExceptionType.CONNECTION_ERROR, null, url, ex);
        }
    }

    /**
     * POST content to the URL with the specified body
     *
     * @param url URL to use in the request
     * @param jsonBody Body to use in the request
     * @return String content
     * @throws TvDbException
     */
    public String postRequest(final URL url, final String jsonBody) throws TvDbException {
        return postRequest(url, jsonBody, null);
    }

    /**
     * POST content to the URL with the specified body
     *
     * @param url URL to use in the request
     * @param jsonBody Body to use in the request
     * @param headers Additional headers to use
     * @return String content
     * @throws TvDbException
     */
    public String postRequest(final URL url, final String jsonBody, final Map<String, String> headers) throws TvDbException {
        try {
            HttpPost httpPost = new HttpPost(url.toURI());
            httpPost.addHeader(HTTP.CONTENT_TYPE, APPLICATION_JSON);
            httpPost.addHeader(HttpHeaders.ACCEPT, APPLICATION_JSON);

            // Add any additional headers if needed
            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    httpPost.addHeader(header.getKey(), header.getValue());
                }
            }

            if (StringUtils.isNotBlank(jsonBody)) {
                StringEntity params = new StringEntity(jsonBody, ContentType.APPLICATION_JSON);
                httpPost.setEntity(params);
            }

            return validateResponse(DigestedResponseReader.postContent(httpClient, httpPost, CHARSET), url);
        } catch (URISyntaxException | IOException ex) {
            throw new TvDbException(ApiExceptionType.CONNECTION_ERROR, null, url, ex);
        }
    }

    /**
     * Check the status codes of the response and throw exceptions if needed
     *
     * @param response DigestedResponse to process
     * @param url URL for notification purposes
     * @return String content
     * @throws TvDbException
     */
    private String validateResponse(final DigestedResponse response, final URL url) throws TvDbException {
        if (response.getStatusCode() == 0) {
            throw new TvDbException(ApiExceptionType.CONNECTION_ERROR, response.getContent(), response.getStatusCode(), url, null);
        } else if (response.getStatusCode() == HttpStatus.SC_UNAUTHORIZED) {
            throw new TvDbException(ApiExceptionType.AUTH_FAILURE, response.getContent(), response.getStatusCode(), url, null);
        } else if (response.getStatusCode() >= HttpStatus.SC_INTERNAL_SERVER_ERROR) {
            throw new TvDbException(ApiExceptionType.HTTP_503_ERROR, response.getContent(), response.getStatusCode(), url, null);
        } else if (response.getStatusCode() >= HttpStatus.SC_MULTIPLE_CHOICES) {
            throw new TvDbException(ApiExceptionType.HTTP_404_ERROR, response.getContent(), response.getStatusCode(), url, null);
        }

        return response.getContent();
    }

}
