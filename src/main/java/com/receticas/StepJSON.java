package com.receticas;

import com.receticas.dao.*;
import com.receticas.models.*;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/recipe/step")

public class StepJSON{

	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStep(@QueryParam("id") PkStep id, @HeaderParam("Authorization") String name ){
		StepDAO dao = new StepDAO();
		Step step = dao.getStep(id);
		UserDAO udao = new UserDAO();
		User user = udao.getUser(name);
		if(step == null)
			return Response.status(404).entity("{}").build();
		if(user == null)
			return Response.status(401).entity("{}").build();

		return Response.status(200).entity(step).build();
	}
}