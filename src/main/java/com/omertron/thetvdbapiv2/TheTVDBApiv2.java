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
package com.omertron.thetvdbapiv2;

import com.omertron.thetvdbapiv2.methods.TvdbAuthentication;
import com.omertron.thetvdbapiv2.methods.TvdbEpisodes;
import com.omertron.thetvdbapiv2.methods.TvdbLanguages;
import com.omertron.thetvdbapiv2.methods.TvdbSearch;
import com.omertron.thetvdbapiv2.methods.TvdbSeries;
import com.omertron.thetvdbapiv2.methods.TvdbUpdates;
import com.omertron.thetvdbapiv2.methods.TvdbUsers;
import com.omertron.thetvdbapiv2.model.AuthenticationToken;
import com.omertron.thetvdbapiv2.tools.HttpTools;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.http.SimpleHttpClientBuilder;

/**
 * The TVDB API v2
 * <p>
 * This is for version 2 of the API as detailed here: https://api.thetvdb.com/swagger#/
 *
 * @author Omertron
 */
public class TheTVDBApiv2 {

    private static final Logger LOG = LoggerFactory.getLogger(TheTVDBApiv2.class);
    private HttpTools httpTools;
    // Methods
    private static TvdbAuthentication tvdbAuthentication;
    private static TvdbEpisodes tvdbEpisodes;
    private static TvdbLanguages tvdbLanguages;
    private static TvdbSearch tvdbSearch;
    private static TvdbSeries tvdbSeries;
    private static TvdbUpdates tvdbUpdates;
    private static TvdbUsers tvdbUsers;

    /**
     * The TVDB API v2
     * <p>
     * You must call the "login" method with your credentials and then use the resulting token to call the "authenticate"
     * method.<br>
     * This will allow access to the rest of the API methods
     *
     * @throws TvDbException
     */
    public TheTVDBApiv2() throws TvDbException {
        this(new SimpleHttpClientBuilder().build());
    }

    /**
     * The TVDB API v2
     *
     * @param httpClient
     * @throws TvDbException
     */
    public TheTVDBApiv2(HttpClient httpClient) throws TvDbException {
        this.httpTools = new HttpTools(httpClient);

        tvdbAuthentication = new TvdbAuthentication(httpTools);
    }

    /**
     * Authenticates all other methods with the token.
     * <p>
     * This MUST be done before any of the other methods are used
     *
     * @param token
     */
    public void authenticate(AuthenticationToken token) {
        initialiseMethods(httpTools);
        authenticateMethods(token);
    }

    /**
     * Update the authentication token
     *
     * @param token
     */
    public void reAuthenticate(AuthenticationToken token) {
        authenticateMethods(token);
    }

    /**
     * Initialise the sub-classes once the API key and http client are known
     *
     * @param apiKey
     * @param httpTools
     */
    private void initialiseMethods(HttpTools httpTools) {
        tvdbEpisodes = new TvdbEpisodes(httpTools);
        tvdbLanguages = new TvdbLanguages(httpTools);
        tvdbSearch = new TvdbSearch(httpTools);
        tvdbSeries = new TvdbSeries(httpTools);
        tvdbUpdates = new TvdbUpdates(httpTools);
        tvdbUsers = new TvdbUsers(httpTools);
    }

    /**
     * Add/Update the authentication token for all the methods
     *
     * @param token
     */
    private void authenticateMethods(AuthenticationToken token) {
        tvdbEpisodes.setAuthToken(token);
        tvdbLanguages.setAuthToken(token);
        tvdbSearch.setAuthToken(token);
        tvdbSeries.setAuthToken(token);
        tvdbUpdates.setAuthToken(token);
        tvdbUsers.setAuthToken(token);
    }

}
