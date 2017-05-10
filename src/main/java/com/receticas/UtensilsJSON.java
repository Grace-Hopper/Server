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



@Path("api/recipe")
public class UtensilsJSON {

	//@GET
	//@Path("utensils")
	//@Produces(MediaType.APPLICATION_JSON)
	//public Response getUtenRecipe(@QueryParam("id") long id, @HeaderParam("Authorization") String name) {
		//RecipeDAO dao = new RecipeDAO();
		//Recipe recipe =dao.getRecipe(id);
		//UserDAO udao = new UserDAO();
		//User user = udao.getUser(name);

		//if(recipe == null)
            //return Response.status(404).entity("{}").build();
////        We can remove this condition if we serve our info even users are not logged in
        //if(user == null)
            //return Response.status(401).entity("{}").build();

		//List<Utensil> uten = recipe.getUtensils();
		//if(uten.size() == 0){
			//return Response.status(422).entity("{}").build();
		//}
		
		//GenericEntity<List<Utensil>> entity = new GenericEntity<List<Utensil>>(uten) {};

		//return Response.status(200).entity(entity).build();
	//}

	//@GET
	//@Path("step/utensils")
	//@Produces(MediaType.APPLICATION_JSON)
	//public Response getUtenStep(@QueryParam("id") long id, @HeaderParam("Authorization") String name) {
		//StepDAO dao = new StepDAO();
		//Step step = dao.getStep(id);
		//UserDAO udao = new UserDAO();
		//User user = udao.getUser(name);
		//if(step == null)
			//return Response.status(404).entity("{}").build();
		//if(user == null)
			//return Response.status(401).entity("{}").build();

		//List<Utensil> uten = step.getUtensils();

		//if(uten.size() == 0){
			//return Response.status(422).entity("{}").build();
		//}
		
		//GenericEntity<List<Utensil>> entity = new GenericEntity<List<Utensil>>(uten) {};

		//return Response.status(200).entity(entity).build();
	//}

}
