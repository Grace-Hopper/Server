package com.receticas.dao;

import com.receticas.models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UtensilDAO {

    public void addUtensil(Utensil bean){
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        addUtensil(session,bean);
        tx.commit();
        session.close();
    }

    private void addUtensil(Session session, Utensil bean){
        Utensil utensil = new Utensil();
        utensil.setName(bean.getName());
        utensil.setRecipe(bean.getRecipe());
        utensil.setStep(bean.getStep());

        session.save(utensil);
        bean.setId(utensil.getId());
    }

    public Utensil getUtensil(long id){
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Utensil utensil = session.get(Utensil.class, id);
        tx.commit();
        session.close();

        return utensil;
    }

    public int deleteUtensil(long id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM utensils WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;
    }

    public int updateUtensil(long id, Utensil ut){
        if(id <=0) return 0;

        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "UPDATE utensils SET name = :name, recipe = :recipe, step = :step WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        query.setParameter("name",ut.getName());
        query.setParameter("step",ut.getStep());
        query.setParameter("recipe",ut.getRecipe());
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;
    }
}
