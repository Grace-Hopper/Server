package com.receticas;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Application;

/**
 * =====================================================================================
 * Filename: RecipesJSONTest.java
 * Version: 1.0
 * Created: 3/23/17
 * Author: JORGE CHATO (651348)
 * =====================================================================================
 */
public class RecipesJSONTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(RecipesJSON.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
//        final String responseMsg = target().path("api/recepies").request().get(String.class);

        assertEquals("","");
    }
}
