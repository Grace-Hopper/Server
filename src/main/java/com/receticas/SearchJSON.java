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
import java.util.*;
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
		List<Recipe> finalList= new ArrayList();
		if(recipes.size()==0){
			recipes=dao.getRelaxedSearch(ingredients);
			
	        List<Integer> numList= new ArrayList();
	        
	        for(Recipe r : recipes){
	            List<Ingredient> ingreList= r.getIngredients();
	            int counter=0;
	            for(Ingredient i : ingredients){ 
	            	String nombre=i.getName();        
	                for(Ingredient j : ingreList){
	                	String name2=j.getName();
	                	if(nombre.equals(name2)){
	                		counter++;
	                		
	                	}
	                }
	            }
	            numList.add(counter);
	        }
	        
	    	int k =numList.size();
	    	int m=0;
	        while(m<k){
	            int strike=0;
	            int i=0;
	            for(int in : numList){
	                if(in>strike){
	                    i=numList.indexOf(in);
	                    strike=in;
	                }
	                
	            }
	            finalList.add(recipes.get(i));
	            numList.remove(i);
	            numList.add(i,0);
	            m++;
	        }

	        if(finalList.size()==0){
	        	finalList=dao.getOutstanding();
	        }

	        GenericEntity<List<Recipe>> entity1 = new GenericEntity<List<Recipe>>(finalList) {};
	        return Response.status(200).entity(entity1).build();       
		}
		else{
			GenericEntity<List<Recipe>> entity = new GenericEntity<List<Recipe>>(recipes) {};
			return Response.status(200).entity(entity).build();
		}

		
		
	}



}