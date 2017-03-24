package com.receticas.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * =====================================================================================
 * Filename: RecipeDAO.java
 * Version: 1.0
 * Created: 3/24/17
 * Author: JORGE CHATO (651348)
 * =====================================================================================
 */
public class RecipeDAO {

    public void addRecipe(Recipe bean){
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        addRecipe(session,bean);
        tx.commit();
        session.close();
    }

    private void addRecipe(Session session, Recipe bean){
        Recipe recipe = new Recipe();

        recipe.setName(bean.getName());

        session.save(recipe);
    }

    public List<Recipe> getRecipes(){
        Session session = SessionUtil.getSession();
        String hql = "FROM recepies";
        Query query = session.createQuery(hql);
        List<Recipe> recipesList =  query.list();
        session.close();

        return recipesList;
    }

    public Recipe getRecipe(int id){
        Session session = SessionUtil.getSession();
        Recipe recipe = session.get(Recipe.class, id);
        session.close();

        return recipe;
    }

    public int deleteRecipe(int id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM recepies WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;
    }

    public int updateRecipe(int id, Recipe rp){
        if(id <=0) return 0;

        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "UPDATE recepies SET name = :name WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        query.setParameter("name",rp.getName());
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;
    }
}
