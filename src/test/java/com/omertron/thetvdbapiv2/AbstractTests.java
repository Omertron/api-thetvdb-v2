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
import com.omertron.thetvdbapiv2.model.AuthenticationToken;
import com.omertron.thetvdbapiv2.tools.HttpTools;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.http.SimpleHttpClientBuilder;
import static org.junit.Assert.fail;

public class AbstractTests {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractTests.class);
    private static final String PROP_FILENAME = "testing.properties";
    private static final String FILENAME_EXT = ".bin";
    private static final Properties PROPS = new Properties();
    private static HttpClient httpClient;
    private static HttpTools httpTools;
    // Constants
    protected static final String PROP_USERNAME = "Username";
    protected static final String PROP_USERKEY = "User_Key";
    protected static final String PROP_APIKEY = "API_Key";
    // Token Info
    private static AuthenticationToken authToken = null;

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

                PROPS.setProperty(PROP_APIKEY, "INSERT_VALUE_HERE");
                PROPS.setProperty(PROP_USERKEY, "INSERT_VALUE_HERE");
                PROPS.setProperty(PROP_USERNAME, "INSERT_VALUE_HERE");

                TestLogger.saveProperties(PROPS, f, "Properties file for tests");
                fail("Failed to get key information from properties file '" + PROP_FILENAME + "'");
            }
        }
    }

    /**
     * Write out the object to a file
     *
     * @param object
     * @param filename
     * @return
     */
    private static boolean writeObject(final Serializable object, final String baseFilename) {
        String filename = baseFilename + FILENAME_EXT;
        File serFile = new File(filename);

        if (serFile.exists()) {
            serFile.delete();
        }

        try {
            byte[] serObject = SerializationUtils.serialize(object);
            FileUtils.writeByteArrayToFile(serFile, serObject);
            return true;
        } catch (IOException ex) {
            LOG.info("Failed to write object to '{}': {}", filename, ex.getMessage(), ex);
            return false;
        }
    }

    /**
     * Read the object back from a file
     *
     * @param <T>
     * @param filename
     * @return
     */
    private static <T> T readObject(final String baseFilename) {
        String filename = baseFilename + FILENAME_EXT;
        File serFile = new File(filename);

        if (serFile.exists()) {
            long diff = System.currentTimeMillis() - serFile.lastModified();
            if (diff < TimeUnit.HOURS.toMillis(1)) {
                LOG.info("File '{}' is current, no need to reacquire", filename);
            } else {
                LOG.info("File '{}' is too old, re-acquiring", filename);
                return null;
            }
        } else {
            LOG.info("File '{}' doesn't exist", filename);
            return null;
        }

        LOG.info("Reading object from '{}'", filename);
        try {
            byte[] serObject = FileUtils.readFileToByteArray(serFile);
            return (T) SerializationUtils.deserialize(serObject);
        } catch (IOException ex) {
            LOG.info("Failed to read {}: {}", filename, ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * get the Session ID
     *
     * @return
     * @throws TvDbException
     */
    protected static final AuthenticationToken getAuthToken() throws TvDbException {
        if (authToken == null) {
            LOG.info("Creating an authentication token for the tests");
            String filename = AuthenticationToken.class.getSimpleName();
            // Try to read the object from a file
            authToken = readObject(filename);

            if (authToken == null) {
                TvdbAuthentication auth = new TvdbAuthentication(getHttpTools());
                authToken = auth.login(PROPS.getProperty(PROP_APIKEY, null),
                        PROPS.getProperty(PROP_USERKEY),
                        PROPS.getProperty(PROP_USERNAME));
                writeObject(authToken, filename);
            }
        }
        return authToken;
    }
    
    /**
     * Get a property from the testing properties
     * @param key
     * @return 
     */
    protected String getProperty(String key) {
        return PROPS.getProperty(key);
    }

    /**
     * Get the Http Tools
     *
     * @return
     */
    protected static HttpTools getHttpTools() {
        return httpTools;
    }

}
