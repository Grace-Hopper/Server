package com.receticas.dao;

import com.receticas.models.Recipe;
import com.receticas.models.Ingredient;
import com.receticas.models.Step;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

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

    /*@Entity(name="id_numId")
    @Table(name="id_numId")
    public class Id_numId implements Serializable {
        @Id
        @Column(name="Ids")
        private long id;

        public long getId(){
            return id;
        }

        public void setId(long id){
            this.id=id;
        }
    }

    @Entity(name="orderIds")
    @Table(name="orderIds")
    public class OrderIds implements Serializable {
        @Id
        @Column(name="id")
        private long id;

        public long getId(){
            return id;
        }

        public void setId(long id){
            this.id=id;
        }

        @Column(name="numId")
        private long numId;

        public long getnumId(){
            return numId;
        }

        public void setnumId(long numId){
            this.numId=numId;
        }
    }*/

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
        recipe.setTotal_time(bean.getTotal_time());
        recipe.setUser(bean.getUser());
        recipe.setPerson(bean.getPerson());
        recipe.setOutstanding(bean.getOutstanding());
        recipe.setPicture(bean.getPicture());

        session.save(recipe);
        bean.setId(recipe.getId());
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
    public List<Recipe> getOutstanding(){
        Session session = SessionUtil.getSession();
        String hql = "FROM recipes where outstanding <> 0";
        Query query = session.createQuery(hql);
        List<Recipe> recipesList = query.list();
        session.close();

        return recipesList;
    }

    public List<Recipe> getIdRecipeSearch(List<Ingredient> ingredients){
        Session session= SessionUtil.getSession();
        String hql = "From recipes r1 Where r1.id IN (Select r.id From recipes r, ";
        int count=0;
        for(Ingredient i : ingredients){
            hql=hql+"ingredients i"+String.valueOf(count)+", ";
            count++;
        }
        count=0;
        hql=hql.substring(0,hql.length()-2);
        hql=hql+" Where ";
        for(Ingredient i : ingredients){
            hql=hql+"r.id=i"+String.valueOf(count)+".recipe and i"+String.valueOf(count)+".name = :i"+String.valueOf(count)+" and ";
            count++;       
        }
        count=1;
        hql=hql.substring(0,hql.length()-5);
        hql=hql+")";
        Query query =session.createQuery(hql);
        String setI="i0";
        for(Ingredient i : ingredients){
            query.setParameter(setI,i.getName());
            setI=setI.substring(0,setI.length()-1);
            setI=setI+String.valueOf(count);
            count++;
        }
        List<Recipe>  recipeList = query.list();
        session.close();

        return recipeList;
    }

    public List<Recipe> getRelaxedSearch(List<Ingredient> ingredients){
        Session session= SessionUtil.getSession();
        String hql = "From recipes r1 where r1.id IN (Select r.id From recipes r, ingredients i Where ";
        int count=0;
        for(Ingredient i : ingredients){
            hql=hql+"(r.id=i.recipe and i.name = :i"+String.valueOf(count)+") or ";
            count++;
        }
        count=1;
        hql=hql.substring(0,hql.length()-4);
        hql=hql+")";
        //hql=hql+"group by r.id order by count(*) desc)";

        Query query =session.createQuery(hql);
        String setI="i0";
        for(Ingredient i : ingredients){
            query.setParameter(setI,i.getName());
            setI=setI.substring(0,setI.length()-1);
            setI=setI+String.valueOf(count);
            count++;
        }
        System.out.println(hql);
        System.out.println(query.getQueryString());
        List<Recipe> recipeList = query.list();

        session.close();



        return recipeList;
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
        String hql = "UPDATE recipes SET name = :name, total_time = :total_time, person = :person, outstanding = :outstanding, picture = :picture WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        query.setParameter("name",rp.getName());
        query.setParameter("total_time",rp.getTotal_time());
        query.setParameter("person",rp.getPerson());
        query.setParameter("outstanding",rp.getOutstanding());
        query.setParameter("picture",rp.getPicture());
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;
    }


}
