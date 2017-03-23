package com.receticas;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
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
		@Path("/")
    @Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
    public Response storeUser(String o) {
				//TODO: Change String to user object
				//TODO: Conect with db, post the user and return a json of the user created
        return Response.status(200).entity(o).build();
    }
}
