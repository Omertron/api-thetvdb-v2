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
package com.omertron.thetvdbapiv2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author stuar
 */
public class Authentication extends AbstractJsonMapping {

    private static final long serialVersionUID = 100L;
    private static final Logger LOG = LoggerFactory.getLogger(Authentication.class);
    @JsonProperty("apikey")
    private String apiKey;
    @JsonProperty("userkey")
    private String userKey;
    @JsonProperty("username")
    private String username;

    public Authentication() {
        this(null, null, null);
    }

    public Authentication(String apiKey, String userKey, String username) {
        this.apiKey = apiKey;
        this.userKey = userKey;
        this.username = username;
    }

    public String ss() {
        try {
            ObjectMapper m = new ObjectMapper();
            return m.writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            LOG.warn("Failed to convert authentication to JSON");
            return "";
        }
    }

    public String getApiKey() {
        return apiKey;

    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
