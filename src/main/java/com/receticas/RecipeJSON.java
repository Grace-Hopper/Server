package com.receticas;

import com.receticas.dao.UserDAO;
import com.receticas.models.Recipe;
import com.receticas.dao.RecipeDAO;
import com.receticas.models.User;

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
    public Response getRecepie(@QueryParam("id") long id, @HeaderParam("Authorization") String name) {
        RecipeDAO dao = new RecipeDAO();
        Recipe recipe = dao.getRecipe(id);
        UserDAO udao = new UserDAO();
        User user = udao.getUser(name);

        if(recipe == null)
            return Response.status(404).entity("{}").build();
//        We can remove this condition if we serve our info even users are not logged in
        if(user == null)
            return Response.status(401).entity("{}").build();

        return Response.status(200).entity(recipe).build();
    }
}
