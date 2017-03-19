/*
 *      Copyright (c) 2017 Stuart Boston
 *
 *      This file is part of TheTVDB API.
 *
 *      TheTVDB API is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      any later version.
 *
 *      TheTVDB API is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with TheTVDB API.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.omertron.thetvdbapiv2.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omertron.thetvdbapiv2.TvDbException;
import com.omertron.thetvdbapiv2.model.AuthenticationToken;
import com.omertron.thetvdbapiv2.tools.HttpTools;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.exception.ApiExceptionType;

/**
 *
 * @author Omertron
 */
public class AbstractMethod {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractMethod.class);
    // API URL
    private static final String API_URL = "https://api.thetvdb.com/";
    // The HttpTools to use
    protected final HttpTools httpTools;
    // The authentication token
    protected AuthenticationToken authToken;
    // Jackson JSON configuration
    protected static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Map<Class, TypeReference> TYPE_REFS = new HashMap<>();

    static {
        // Add type refs here
    }

    /**
     * Default constructor for the methods
     *
     * @param apiKey
     * @param httpTools
     */
    public AbstractMethod(HttpTools httpTools) {
        this.httpTools = httpTools;
    }

    /**
     * Helper function to get a pre-generated TypeReference for a class
     *
     * @param aClass
     * @return
     * @throws com.omertron.thetvdbapiv2.TvDbException
     * @throws MovieDbException
     */
    protected static TypeReference getTypeReference(Class aClass) throws TvDbException {
        if (TYPE_REFS.containsKey(aClass)) {
            return TYPE_REFS.get(aClass);
        } else {
            throw new TvDbException(ApiExceptionType.UNKNOWN_CAUSE, "Class type reference for '" + aClass.getSimpleName() + "' not found!");
        }
    }

    /**
     * Get the authentication token for the session
     *
     * @return
     * @throws TvDbException
     */
    public AuthenticationToken getAuthToken() throws TvDbException {
        if (authToken == null) {
            throw new TvDbException(ApiExceptionType.AUTH_FAILURE, "No/Invalid Authentication Token");
        }
        return authToken;
    }

    /**
     * Set the authentication token to be used throughout the session
     *
     * @param authToken
     */
    public void setAuthToken(AuthenticationToken authToken) {
        this.authToken = authToken;
    }

    /**
     * Create a URL to the API calls
     *
     * @param methodPath
     * @param param
     * @return
     * @throws TvDbException
     */
    protected URL generateUrl(final String methodPath, final Object param) throws TvDbException {
        StringBuilder builder = new StringBuilder(API_URL);
        builder.append(methodPath);

        if (param != null) {
            builder.append("/")
                    .append(param.toString());
        }
        LOG.info("URL: {}", builder.toString());

        try {
            return new URL(builder.toString());
        } catch (MalformedURLException ex) {
            LOG.warn("Failed to convert '{}' into a URL", builder.toString());
            throw new TvDbException(ApiExceptionType.INVALID_URL, ex.getMessage(), builder.toString(), ex);
        }
    }

    protected String getJsonData(URL url) throws TvDbException {
        Map<String, String> headers = new HashMap<>();
        headers.put(HttpHeaders.AUTHORIZATION, "Bearer " + getAuthToken().getToken());

        String result = httpTools.postRequest(url, null, headers);
        LOG.info(result);

        return result;
    }
}
