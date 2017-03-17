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
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author stuar
 */
public class TvdbEpisodesTest extends AbstractTests {

    private static final Logger LOG = LoggerFactory.getLogger(TvdbEpisodesTest.class);
    private static TvdbEpisodes instance;

    public TvdbEpisodesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws TvDbException {
        doConfiguration();
        instance = new TvdbEpisodes(getApiKey(), getHttpTools());
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
     * Test of episodes method, of class TvdbEpisodes.
     */
    @Test
    public void testEpisodes() {
        System.out.println("episodes");
        instance.episodes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
