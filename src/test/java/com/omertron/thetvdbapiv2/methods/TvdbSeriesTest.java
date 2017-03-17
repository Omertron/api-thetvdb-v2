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
public class TvdbSeriesTest extends AbstractTests {

    private static final Logger LOG = LoggerFactory.getLogger(TvdbSeriesTest.class);
    private static TvdbSeries instance;

    public TvdbSeriesTest() {
    }

    @BeforeClass
    public static void setUpClass() throws TvDbException {
        doConfiguration();
        instance = new TvdbSeries(getApiKey(), getHttpTools());
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
     * Test of series method, of class TvdbSeries.
     */
    @Test
    public void testSeries() {
        System.out.println("series");
        long id = 0L;
        instance.series(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seriesHead method, of class TvdbSeries.
     */
    @Test
    public void testSeriesHead() {
        System.out.println("seriesHead");
        long id = 0L;
        TvdbSeries instance = null;
        instance.seriesHead(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actors method, of class TvdbSeries.
     */
    @Test
    public void testActors() {
        System.out.println("actors");
        long id = 0L;
        TvdbSeries instance = null;
        instance.actors(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of episodes method, of class TvdbSeries.
     */
    @Test
    public void testEpisodes() {
        System.out.println("episodes");
        long id = 0L;
        TvdbSeries instance = null;
        instance.episodes(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of episodesQuery method, of class TvdbSeries.
     */
    @Test
    public void testEpisodesQuery() {
        System.out.println("episodesQuery");
        long id = 0L;
        TvdbSeries instance = null;
        instance.episodesQuery(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of episodesQueryParams method, of class TvdbSeries.
     */
    @Test
    public void testEpisodesQueryParams() {
        System.out.println("episodesQueryParams");
        TvdbSeries instance = null;
        instance.episodesQueryParams();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of episodesSummary method, of class TvdbSeries.
     */
    @Test
    public void testEpisodesSummary() {
        System.out.println("episodesSummary");
        long id = 0L;
        TvdbSeries instance = null;
        instance.episodesSummary(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filter method, of class TvdbSeries.
     */
    @Test
    public void testFilter() {
        System.out.println("filter");
        long id = 0L;
        TvdbSeries instance = null;
        instance.filter(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filterParams method, of class TvdbSeries.
     */
    @Test
    public void testFilterParams() {
        System.out.println("filterParams");
        long id = 0L;
        TvdbSeries instance = null;
        instance.filterParams(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of images method, of class TvdbSeries.
     */
    @Test
    public void testImages() {
        System.out.println("images");
        long id = 0L;
        TvdbSeries instance = null;
        instance.images(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
