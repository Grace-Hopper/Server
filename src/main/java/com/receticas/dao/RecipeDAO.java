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
        String hql = "FROM recipes";
        Query query = session.createQuery(hql);
        List<Recipe> recipesList = query.list();
        session.close();

        return recipesList;
    }

    public Recipe getRecipe(long id){
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Recipe recipe = session.get(Recipe.class, id);
        tx.commit();
        session.close();

        return recipe;
    }

    public int deleteRecipe(long id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM recipes WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;
    }

    public int updateRecipe(long id, Recipe rp){
        if(id <=0) return 0;

        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "UPDATE recipes SET name = :name, total_time = :total_time, user = :user WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        query.setParameter("name",rp.getName());
        query.setParameter("total_time",rp.getTotal_time());
        query.setParameter("user",rp.getUser().getId());
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;
    }
}
