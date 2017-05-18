package com.receticas;


import com.receticas.models.Recipe;
import com.receticas.dao.RecipeDAO;
import com.receticas.models.Ingredient;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import javax.ws.rs.*;

@Path("api/search")
public class SearchJSON{

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getSearch(List<Ingredient> ingredients){
		RecipeDAO dao= new RecipeDAO();
		List<Recipe> recipes=dao.getIdRecipeSearch(ingredients);
		if(recipes.size()==0){
			recipes=dao.getRelaxedSearch(ingredients);
		}

		GenericEntity<List<Recipe>> entity = new GenericEntity<List<Recipe>>(recipes) {};
		return Response.status(200).entity(entity).build();
	}



}