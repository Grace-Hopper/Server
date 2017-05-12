package com.receticas;

import com.receticas.dao.*;
import com.receticas.models.*;

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
    /**
     * Method handling HTTP PUT requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as a application/json response.
     */
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response upgradeRecipe(Recipe rp) {
        RecipeDAO dao = new RecipeDAO();
        StepDAO sdao = new StepDAO();
        IngredientDAO idao = new IngredientDAO();
        UtensilDAO udao = new UtensilDAO();
        Recipe exist = dao.getRecipe(rp.getId());

        if(exist != null) {
            dao.updateRecipe(rp.getId(), rp);

            for (Ingredient in : rp.getIngredients()){
                Ingredient iexist = idao.getIngredient(in.getId());
                if(iexist != null) {
                    idao.updateIngredient(in.getId(), in);
                }
            }
            for (Utensil in : rp.getUtensils()){
                Utensil iexist = udao.getUtensil(in.getId());
                if(iexist != null) {
                    udao.updateUtensil(in.getId(), in);
                }
            }

            for (Step st : rp.getSteps()){
                Step sexist = sdao.getStep(st.getId());
                if(sexist != null) {
                    sdao.updateStep(st.getId(), st);
                }

                for (Ingredient in : st.getIngredients()){
                    Ingredient iexist = idao.getIngredient(in.getId());
                    if(iexist != null) {
                        idao.updateIngredient(in.getId(), in);
                    }
                }
                for (Utensil in : st.getUtensils()){
                    Utensil iexist = udao.getUtensil(in.getId());
                    if(iexist != null) {
                        udao.updateUtensil(in.getId(), in);
                    }
                }
            }
            return Response.status(200).entity(rp).build();
        }

        return Response.status(404).entity("{}").build();
    }
    /**
     * Method handling HTTP POST requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as a application/json response.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response storeRecipe(Recipe rp) {
        RecipeDAO dao = new RecipeDAO();
        StepDAO sdao = new StepDAO();
        IngredientDAO idao = new IngredientDAO();
        UtensilDAO udao = new UtensilDAO();

        dao.addRecipe(rp);
        long rid = rp.getId();

        for (Ingredient in : rp.getIngredients()){
            in.setRecipe(rid);
            in.setStep(-1);
            idao.addIngredient(in);
        }
        for (Utensil in : rp.getUtensils()){
            in.setRecipe(rid);
            in.setStep(-1);
            udao.addUtensil(in);
        }

        for (Step st : rp.getSteps()){
            st.setRecipe(rid);
            sdao.addStep(st);
            long sid = st.getId();

            for (Ingredient in : st.getIngredients()){
                in.setStep(sid);
                in.setRecipe(-1);
                idao.addIngredient(in);
            }
            for (Utensil in : st.getUtensils()){
                in.setStep(sid);
                in.setRecipe(-1);
                udao.addUtensil(in);
            }
        }
        return Response.status(200).entity(rp).build();
    }
}
