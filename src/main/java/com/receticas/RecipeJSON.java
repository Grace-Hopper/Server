package com.receticas;

import com.receticas.models.Recipe;
import com.receticas.dao.RecipeDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    public Response getRecepie(@QueryParam("id") long id, @HeaderParam("Authorization") String token) {
        RecipeDAO dao = new RecipeDAO();
        Recipe recipe = dao.getRecipe(id);

        if(recipe == null)
            return Response.status(404).entity("{}").build();
        if(new UserJSON().getUser(token) == null)
            return Response.status(401).entity("{}").build();

        return Response.status(200).entity(recipe).build();
    }
}
