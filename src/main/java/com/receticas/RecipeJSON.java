package com.receticas;

import com.receticas.dao.Recipe;
import com.receticas.dao.RecipeDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "api/recepie" path)
 */
@Path("api/recipe")
public class RecipeJSON {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as a application/json response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecepie(@QueryParam("id") long id) {
        RecipeDAO dao = new RecipeDAO();
        Recipe recipe = dao.getRecipe(id);

        if(recipe == null) return Response.status(Response.Status.NOT_FOUND).entity("{}").build();

        return Response.status(200).entity(recipe).build();
    }
}
