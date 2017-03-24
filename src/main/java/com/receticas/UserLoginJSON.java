package com.receticas;

import com.receticas.dao.User;
import com.receticas.dao.UserDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "api/userId" path)
 */
@Path("api/userId")
public class UserLoginJSON {
	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as a application/json response.
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserId(@QueryParam("id") int id, @QueryParam("password") String password) {
        UserDAO dao = new UserDAO();
        User user = dao.getUser(id);

        if(user == null){
            return Response.status(404).build();
        }
        else{
            if(!user.getPassword().equals(password)) return Response.status(422).build();
        }
        return Response.status(200).entity(user).build();
    }
}