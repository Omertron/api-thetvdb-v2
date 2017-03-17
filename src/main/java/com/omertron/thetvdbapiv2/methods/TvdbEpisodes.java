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
 * Episodes: Information about a specific episode
 *
 * @author Omertron
 */
public class TvdbEpisodes extends AbstractMethod {

    public TvdbEpisodes(String apiKey, HttpTools httpTools) {
        super(apiKey, httpTools);
    }

    /**
     * Returns the full information for a given episode id.
     */
    public void episodes() {
    }
}
