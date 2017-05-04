package com.receticas.dao;

import com.receticas.models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class IngredientDAO {

    public void addIngredient(Ingredient bean){
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        addIngredient(session,bean);
        tx.commit();
        session.close();
    }

    private void addIngredient(Session session, Ingredient bean){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(bean.getName());

        session.save(ingredient);
    }

    public Ingredient getIngredient(long id){
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Ingredient ingredient = session.get(Ingredient.class, id);
        tx.commit();
        session.close();

        return ingredient;
    }

    public int deleteIngredient(long id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM ingredients WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;
    }

    public int updateIngredient(long id, Ingredient ig){
        if(id <=0) return 0;

        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "UPDATE ingredients SET name = :name WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        query.setParameter("name",ig.getName());
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;
    }
}
