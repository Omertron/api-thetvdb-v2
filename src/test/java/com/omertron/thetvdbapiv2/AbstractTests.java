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

import com.omertron.thetvdbapiv2.tools.HttpTools;
import java.io.File;
import java.util.Properties;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.http.SimpleHttpClientBuilder;
import static org.junit.Assert.fail;

public class AbstractTests {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractTests.class);
    private static final String PROP_FILENAME = "testing.properties";
    private static final Properties PROPS = new Properties();
    private static HttpClient httpClient;
    private static HttpTools httpTools;
    // Constants
    protected static final String LANGUAGE_DEFAULT = "";
    protected static final String LANGUAGE_ENGLISH = "en";

    /**
     * Do the initial configuration for the test cases
     *
     * @throws TvDbException
     */
    protected static final void doConfiguration() throws TvDbException {
        TestLogger.configure();
        httpClient = new SimpleHttpClientBuilder().build();
        httpTools = new HttpTools(httpClient);

        if (PROPS.isEmpty()) {
            File f = new File(PROP_FILENAME);
            if (f.exists()) {
                LOG.info("Loading properties from '{}'", PROP_FILENAME);
                TestLogger.loadProperties(PROPS, f);
            } else {
                LOG.info("Property file '{}' not found, creating dummy file.", PROP_FILENAME);

                PROPS.setProperty("API_Key", "INSERT_YOUR_KEY_HERE");
                PROPS.setProperty("Username", "INSERT_YOUR_USERNAME_HERE");
                PROPS.setProperty("Password", "INSERT_YOUR_PASSWORD_HERE");

                TestLogger.saveProperties(PROPS, f, "Properties file for tests");
                fail("Failed to get key information from properties file '" + PROP_FILENAME + "'");
            }
        }
    }

    /**
     * get the Http Client
     *
     * @return
     */
    protected static HttpClient getHttpClient() {
        return httpClient;
    }

    /**
     * Get the Http Tools
     *
     * @return
     */
    protected static HttpTools getHttpTools() {
        return httpTools;
    }

    /**
     * Get the API Key
     *
     * @return
     */
    protected static String getApiKey() {
        return PROPS.getProperty("API_Key");
    }

    /**
     * Get the Account username
     *
     * @return
     */
    protected static String getUsername() {
        return PROPS.getProperty("Username");
    }

    /**
     * Get the Account password
     *
     * @return
     */
    protected static String getPassword() {
        return PROPS.getProperty("Password");
    }

}
