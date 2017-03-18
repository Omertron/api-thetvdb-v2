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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.omertron.thetvdbapiv2.TvDbException;
import com.omertron.thetvdbapiv2.model.Authentication;
import com.omertron.thetvdbapiv2.model.AuthenticationToken;
import com.omertron.thetvdbapiv2.tools.HttpTools;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.exception.ApiExceptionType;

/**
 * Authentication: Obtaining and refreshing your JWT token
 *
 * @author Omertron
 */
public class TvdbAuthentication extends AbstractMethod {

    private static final Logger LOG = LoggerFactory.getLogger(TvdbAuthentication.class);

    public TvdbAuthentication(HttpTools httpTools) {
        super(httpTools);
    }

    /**
     * Returns a session token to be included in the rest of the requests.
     * <p>
     * Note that API key authentication is required for all subsequent requests and user auth is required for routes in the User
     * section
     *
     * @param apikey
     * @param userkey
     * @param username
     * @return
     * @throws com.omertron.thetvdbapiv2.TvDbException
     */
    public AuthenticationToken login(final String apikey, final String userkey, final String username) throws TvDbException {
        String urlString = "https://api.thetvdb.com/login";
        try {
            Authentication auth = new Authentication(apikey, userkey, username);
            String authJson = MAPPER.writeValueAsString(auth);

            URL url = new URL(urlString);
            String webpage = httpTools.postRequest(url, authJson);

            AuthenticationToken token = MAPPER.readValue(webpage, AuthenticationToken.class);
            return token;
        } catch (JsonProcessingException ex) {
            LOG.warn("Failed to process JSON from TheTVDB");
            throw new TvDbException(ApiExceptionType.MAPPING_FAILED, ex.getMessage(), urlString, ex);
        } catch (MalformedURLException ex) {
            LOG.warn("Faied to create URL");
            throw new TvDbException(ApiExceptionType.INVALID_URL, ex.getMessage(), urlString, ex);
        } catch (IOException ex) {
            LOG.warn("Failed to get URL data");
            throw new TvDbException(ApiExceptionType.INVALID_URL, ex.getMessage(), urlString, ex);
        } catch (TvDbException ex) {
            LOG.warn("Failed to get web data");
            throw new TvDbException(ApiExceptionType.CONNECTION_ERROR, ex.getMessage(), urlString, ex);
        }
    }

    /**
     * Refreshes your current, valid JWT token and returns a new token.
     * <p>
     * Hit this route so that you do not have to post to /login with your API key and credentials once you have already been
     * authenticated.
     *
     * @param token
     * @return
     */
    public AuthenticationToken refreshToken(final AuthenticationToken token) {

        return new AuthenticationToken();
    }
}
