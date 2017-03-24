package com.receticas;

import com.receticas.dao.User;
import com.receticas.dao.UserDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "api/user" path)
 */
@Path("api/user")
public class UserJSON {

    /**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as a application/json response.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response storeUser(User user) {
//        UserDAO dao = new UserDAO();
//        dao.addUser(user);
        return Response.status(200).entity(user).build();
    }
}
