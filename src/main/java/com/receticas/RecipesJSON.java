package com.receticas;

import com.receticas.dao.UserDAO;
import com.receticas.models.Recipe;
import com.receticas.dao.RecipeDAO;
import com.receticas.models.User;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
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
     * @return String that will be returned as a application/json response.
     */
    @GET
		@Path("outstanding")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOutstanding(@HeaderParam("Authorization") String name) {
        RecipeDAO dao = new RecipeDAO();
        List<Recipe> recipes = dao.getOutstanding();
        UserDAO udao = new UserDAO();
        User user = udao.getUser(name);

        if(recipes.size() == 0)
            return Response.status(404).entity("{}").build();
//        We can remove this condition if we serve our info even users are not logged in
        if(user == null)
            return Response.status(401).entity("{}").build();

        GenericEntity<List<Recipe>> entity = new GenericEntity<List<Recipe>>(recipes) {};

        return Response.status(200).entity(entity).build();
    }

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return list of recepies that will be returned as a application/json response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRecepies(@HeaderParam("Authorization") String name) {
        RecipeDAO dao = new RecipeDAO();
        List<Recipe> recipes = dao.getRecipes();
        UserDAO udao = new UserDAO();
        User user = udao.getUser(name);

        if(recipes.size() == 0)
            return Response.status(404).entity("[]").build();
//        We can remove this condition if we serve our info even users are not logged in
        if(user == null)
            return Response.status(401).entity("[]").build();

        GenericEntity<List<Recipe>> entity = new GenericEntity<List<Recipe>>(recipes) {};

        return Response.status(200).entity(entity).build();
    }
}
