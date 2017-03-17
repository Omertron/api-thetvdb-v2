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
 * Authentication: Obtaining and refreshing your JWT token
 *
 * @author Omertron
 */
public class TvdbAuthentication extends AbstractMethod {

    public TvdbAuthentication(String apiKey, HttpTools httpTools) {
        super(apiKey, httpTools);
    }

    /**
     * Returns a session token to be included in the rest of the requests.
     * <p>
     * Note that API key authentication is required for all subsequent requests
     * and user auth is required for routes in the User section
     *
     */
    public void login() {
    }

    /**
     * Refreshes your current, valid JWT token and returns a new token.
     * <p>
     * Hit this route so that you do not have to post to /login with your API
     * key and credentials once you have already been authenticated.
     *
     */
    public void refreshToken() {
    }
}
