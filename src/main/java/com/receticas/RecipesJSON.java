package com.receticas;

import com.receticas.models.Recipe;
import com.receticas.dao.RecipeDAO;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Root resource (exposed at "api/recepies" path)
 */
@Path("api/recipes")
public class RecipesJSON {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return list of recepies that will be returned as a application/json response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecepies(@HeaderParam("Authorization") String token) {
        RecipeDAO dao = new RecipeDAO();
        List<Recipe> recipes = dao.getRecipes();

        if(recipes.size() == 0)
            return Response.status(404).entity("[]").build();
        if(new UserJSON().getUser(token) == null)
            return Response.status(401).entity("[]").build();

        return Response.status(200).entity(recipes).build();
    }
}
