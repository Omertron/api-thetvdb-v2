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
        instance = new TvdbSeries(getHttpTools());
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
        LOG.info("series");
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
        LOG.info("seriesHead");
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
        LOG.info("actors");
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
        LOG.info("episodes");
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
        LOG.info("episodesQuery");
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
        LOG.info("episodesQueryParams");
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
        LOG.info("episodesSummary");
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
        LOG.info("filter");
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
        LOG.info("filterParams");
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
        LOG.info("images");
        long id = 0L;
        TvdbSeries instance = null;
        instance.images(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
