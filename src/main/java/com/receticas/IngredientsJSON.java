package com.receticas;

import com.receticas.models.*;
import com.receticas.dao.*;

import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.persistence.*;

import java.util.*;



@Path("api/recipe/inf")
public class IngredientsJSON {

	//@GET
	//@Path("ingredients")
	//@Produces(MediaType.APPLICATION_JSON)
	//public Response getIngRecipe(@QueryParam("id") long id, @HeaderParam("Authorization") String name) {
		//RecipeDAO dao = new RecipeDAO();
		//Recipe recipe =dao.getRecipe(id);
		//UserDAO udao = new UserDAO();
		//User user = udao.getUser(name);

		//if(recipe == null)
			//return Response.status(404).entity("{}").build();
////        We can remove this condition if we serve our info even users are not logged in
    //if(user == null)
			//return Response.status(401).entity("{}").build();

		//List<Ingredient> ingredients = recipe.getIngredients();

		//if(ingredients.size() == 0){
			//return Response.status(422).entity("{}").build();
		//}
		
		//GenericEntity<List<Ingredient>> entity = new GenericEntity<List<Ingredient>>(ingredients) {};

		//return Response.status(200).entity(entity).build();
	//}

	//@GET
	//@Path("step/ingredients")
	//@Produces(MediaType.APPLICATION_JSON)
	//public Response getIngStep(@QueryParam("id") long id, @HeaderParam("Authorization") String name) {
		//StepDAO dao = new StepDAO();
		//Step step = dao.getStep(id);
		//UserDAO udao = new UserDAO();
		//User user = udao.getUser(name);
		//if(step == null)
			//return Response.status(404).entity("{}").build();
		//if(user == null)
			//return Response.status(401).entity("{}").build();

		//List<Ingredient> ingredients = step.getIngredients();

		//if(ingredients.size() == 0){
			//return Response.status(422).entity("{}").build();
		//}
		
		//GenericEntity<List<Ingredient>> entity = new GenericEntity<List<Ingredient>>(ingredients) {};

		//return Response.status(200).entity(entity).build();
	//}

}
