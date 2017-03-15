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
import com.omertron.thetvdbapiv2.tools.HttpTools;
import java.util.HashMap;
import java.util.Map;
import org.yamj.api.common.exception.ApiExceptionType;

/**
 *
 * @author stuar
 */
public class AbstractMethod {

    // The API key to be used
    protected final String apiKey;
    // The HttpTools to use
    protected final HttpTools httpTools;
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
    public AbstractMethod(String apiKey, HttpTools httpTools) {
        this.apiKey = apiKey;
        this.httpTools = httpTools;
    }

    /**
     * Helper function to get a pre-generated TypeReference for a class
     *
     * @param aClass
     * @return
     * @throws MovieDbException
     */
    protected static TypeReference getTypeReference(Class aClass) throws TvDbException {
        if (TYPE_REFS.containsKey(aClass)) {
            return TYPE_REFS.get(aClass);
        } else {
            throw new TvDbException(ApiExceptionType.UNKNOWN_CAUSE, "Class type reference for '" + aClass.getSimpleName() + "' not found!");
        }
    }

}
