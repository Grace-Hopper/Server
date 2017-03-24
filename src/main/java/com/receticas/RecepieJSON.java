package com.receticas;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "api/recepie" path)
 */
@Path("api/recepie")
public class RecepieJSON {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as a application/json response.
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecepie(@QueryParam("id") int id) {
        //TODO: Conect with db and return a json of a recepie when recepie.id = id
        return Response.status(200).entity("id: "+id).build();
    }
}
