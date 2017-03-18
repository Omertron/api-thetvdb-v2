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

import com.omertron.thetvdbapiv2.AbstractTests;
import com.omertron.thetvdbapiv2.TvDbException;
import com.omertron.thetvdbapiv2.model.AuthenticationToken;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TvdbAuthenticationTest extends AbstractTests {

    private static final Logger LOG = LoggerFactory.getLogger(TvdbAuthenticationTest.class);
    private static TvdbAuthentication instance;

    public TvdbAuthenticationTest() throws TvDbException {
    }

    @BeforeClass
    public static void setUpClass() throws TvDbException {
        doConfiguration();
        instance = new TvdbAuthentication(getHttpTools());
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class TvdbAuthentication.
     *
     * @throws com.omertron.thetvdbapiv2.TvDbException
     */
    @Test
    public void testLogin() throws TvDbException {
        LOG.info("login");
        AuthenticationToken token = instance.login(getProperty(PROP_APIKEY), getProperty(PROP_USERKEY), null);
        LOG.info("{}", token.toString());

        assertNotNull("No token", token.getToken());
        assertTrue("No token", !token.getToken().isEmpty());
    }

    /**
     * Test of refreshToken method, of class TvdbAuthentication.
     *
     * @throws com.omertron.thetvdbapiv2.TvDbException
     */
    @Test
    public void testRefreshToken() throws TvDbException {
        LOG.info("refreshToken");

        AuthenticationToken token = instance.login(getProperty(PROP_APIKEY), getProperty(PROP_USERKEY), null);
        LOG.info("1st Token: {}", token.getToken());
        AuthenticationToken newToken = instance.refreshToken(token);
        LOG.info("2nd Token: {}", newToken.getToken());
        assertNotEquals("Same token returned", token.getToken(), newToken.getToken());
    }

}
