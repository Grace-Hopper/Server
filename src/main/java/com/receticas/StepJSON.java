package com.receticas;

import com.receticas.dao.*;
import com.receticas.models.*;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;
import java.util.*;

@Path("api/recipe/step")

public class StepJSON{

	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStepp(@QueryParam("id") long id, @HeaderParam("Authorization") String name ){
		RecipeDAO dao = new RecipeDAO();
        Recipe recipe = dao.getRecipe(id);
        List<Step> orderSteps = dao.getStepsRecipe(recipe);
        UserDAO udao = new UserDAO();
        User user = udao.getUser(name);

        if(orderSteps.size() == 0)
            return Response.status(404).entity("{}").build();
//        We can remove this condition if we serve our info even users are not logged in
        if(user == null)
            return Response.status(401).entity("{}").build();

       	GenericEntity<List<Step>> entity = new GenericEntity<List<Step>>(orderSteps) {};

		return Response.status(200).entity(entity).build();
	}
}