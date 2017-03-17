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
import com.omertron.thetvdbapiv2.tools.HttpTools;
import org.apache.http.client.HttpClient;
import org.yamj.api.common.http.SimpleHttpClientBuilder;

/**
 * The TVDB API v2
 * <p>
 * This is for version 2 of the API as detailed here: https://api.thetvdb.com/swagger#/
 *
 * @author Omertron
 */
public class TheTVDBApiv2 {

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
     *
     * @param apiKey
     * @throws TvDbException
     */
    public TheTVDBApiv2(String apiKey) throws TvDbException {
        this(apiKey, new SimpleHttpClientBuilder().build());
    }

    /**
     * The TVDB API v2
     *
     * @param apiKey
     * @param httpClient
     * @throws TvDbException
     */
    public TheTVDBApiv2(String apiKey, HttpClient httpClient) throws TvDbException {
        this.httpTools = new HttpTools(httpClient);
        initialise(apiKey, httpTools);
    }

    /**
     * Initialise the sub-classes once the API key and http client are known
     *
     * @param apiKey
     * @param httpTools
     */
    private void initialise(String apiKey, HttpTools httpTools) {
        tvdbAuthentication = new TvdbAuthentication(apiKey, httpTools);
        tvdbEpisodes = new TvdbEpisodes(apiKey, httpTools);
        tvdbLanguages = new TvdbLanguages(apiKey, httpTools);
        tvdbSearch = new TvdbSearch(apiKey, httpTools);
        tvdbSeries = new TvdbSeries(apiKey, httpTools);
        tvdbUpdates = new TvdbUpdates(apiKey, httpTools);
        tvdbUsers = new TvdbUsers(apiKey, httpTools);
    }

    
}
