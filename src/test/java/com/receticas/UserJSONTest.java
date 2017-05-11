package com.receticas;

import com.receticas.models.User;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * =====================================================================================
 * Filename: UserJSONTest.java
 * Version: 1.0
 * Created: 3/24/17
 * Author: JORGE CHATO (651348)
 * =====================================================================================
 */
public class UserJSONTest extends JerseyTest{
    @Override
    protected Application configure() {
        return new ResourceConfig(UserJSON.class);
    }

    /**
     * Test to see that the user was created.
     */
    @Test
    public void testGetIt() {
        String aux = UUID.randomUUID().toString().toUpperCase();

        User user = new User();
        user.setName(aux);
        user.setPassword(aux);

        Entity<User> userEntity = Entity.entity(user, MediaType.APPLICATION_JSON);

        Response response = target().path("api/user/signup").request().post(userEntity);

//        assertEquals("Should return status 200", 200, response.getStatus());
        assertNotNull("Should return notification", response.getEntity());
    }
}
