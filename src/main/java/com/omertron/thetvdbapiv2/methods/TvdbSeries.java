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

import com.omertron.thetvdbapiv2.tools.HttpTools;

/**
 * Series: Information about a specific series
 *
 * @author Omertron
 */
public class TvdbSeries extends AbstractMethod {

    public TvdbSeries(String apiKey, HttpTools httpTools) {
        super(apiKey, httpTools);
    }

    /**
     * Returns a series records that contains all information known about a
     * particular series id.
     *
     * @param id ID of the series
     */
    public void series(long id) {
    }

    /**
     * Returns header information only about the given series ID.
     *
     * @param id ID of the series
     */
    public void seriesHead(long id) {
    }

    /**
     * Returns actors for the given series id
     *
     * @param id ID of the series
     */
    public void actors(long id) {
    }

    /**
     * All episodes for a given series.
     * <p>
     * Paginated with 100 results per page.
     *
     * @param id ID of the series
     */
    public void episodes(long id) {
    }

    /**
     * Query against episodes for the given series ID.
     * <p>
     * The response is a paginated array of episode records that have been
     * filtered down to basic information.
     *
     * @param id ID of the series
     */
    public void episodesQuery(long id) {
    }

    /**
     * Returns the allowed query keys for the episodesQuery
     *
     */
    public void episodesQueryParams() {
    }

    /**
     * Returns a summary of the episodes and seasons available for the series.
     *
     * @param id ID of the series
     */
    public void episodesSummary(long id) {
    }

    /**
     * Returns a series records, filtered by the supplied comma-separated list
     * of keys.
     * <p>
     * Query keys can be found at the filterParams.
     *
     * @param id ID of the series
     */
    public void filter(long id) {
    }

    /**
     * Returns the list of keys available for the /series/{id}/filter route
     *
     * @param id ID of the series
     */
    public void filterParams(long id) {
    }

    /**
     * Returns a summary of the images for a particular series
     *
     * @param id ID of the series
     */
    public void images(long id) {
    }
}
