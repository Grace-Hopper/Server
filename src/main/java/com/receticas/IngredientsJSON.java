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



@Path("api/ingredients")
public class IngredientsJSON {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIngRecipe(@QueryParam("id") long id, @HeaderParam("Authorization") String name) {
		RecipeDAO dao = new RecipeDAO();
		Recipe recipe =dao.getRecipe(id);
		UserDAO udao = new UserDAO();
		User user = udao.getUser(name);

		if(recipe == null)
            return Response.status(404).entity("{}").build();
//        We can remove this condition if we serve our info even users are not logged in
        if(user == null)
            return Response.status(401).entity("{}").build();

		List<IngreRecipe> ingredients = recipe.getIngredients();
		List<IngreQuantity> ingQuan = new ArrayList();
		for(IngreRecipe i : ingredients){
			IngreQuantity aux= new IngreQuantity();
			aux.setIngreName(i.getIngreRecipe().getIngredient().getName());
			aux.setIngreQuant(i.getQuantity());
			ingQuan.add(aux);
		}

		if(ingQuan.size() == 0){
			return Response.status(422).entity("{}").build();
		}
		
		GenericEntity<List<IngreQuantity>> entity = new GenericEntity<List<IngreQuantity>>(ingQuan) {};

		return Response.status(200).entity(entity).build();
	}

}