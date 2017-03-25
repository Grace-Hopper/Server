package com.receticas;

import com.receticas.models.User;
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
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as a application/json response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@HeaderParam("Authorization") String token) {
        UserDAO dao = new UserDAO();
        User user = dao.getUser(token);

        if(user == null) return Response.status(404).entity("{}").build();

        return Response.status(200).entity(user).build();
    }
    /**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as a application/json response.
     */
    @POST
    @Path("signup")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response storeUser(User user) {
        UserDAO dao = new UserDAO();
        dao.addUser(user);

        return Response.status(200).entity(user).build();
    }
    /**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as a application/json response.
     */
    @POST
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginUser(User user) {
        UserDAO dao = new UserDAO();
        User logged = dao.getUser(user.getName());

        if(logged == null)
            return Response.status(404).entity("{}").build();
        else
            if(!logged.getPassword().equals(user.getPassword()))
                return Response.status(422).entity("{}").build();

        return Response.status(200).entity(logged).build();
    }
}
