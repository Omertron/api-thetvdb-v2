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
 * Languages: Available languages and information
 *
 * @author Omertron
 */
public class TvdbLanguages extends AbstractMethod {

    public TvdbLanguages(String apiKey, HttpTools httpTools) {
        super(apiKey, httpTools);
    }

    /**
     * All available languages.
     * <p>
     * These language abbreviations can be used in the Accept-Language header
     * for routes that return translation records
     */
    public void languages() {
    }

    /**
     * Information about a particular language, given the language ID
     *
     * @param id
     */
    public void languages(int id) {
    }
}
