package com.receticas;

import com.receticas.dao.Recepie;
import com.receticas.dao.RecepieDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Root resource (exposed at "api/recepies" path)
 */
@Path("api/recepies")
public class RecepiesJSON {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return list of recepies that will be returned as a application/json response.
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecepies() {
        RecepieDAO dao = new RecepieDAO();
        List<Recepie> recepies = dao.getRecepies();

        return Response.status(200).entity(recepies).build();
    }
}
