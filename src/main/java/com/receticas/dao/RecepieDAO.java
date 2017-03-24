package com.receticas.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * =====================================================================================
 * Filename: RecepieDAO.java
 * Version: 1.0
 * Created: 3/24/17
 * Author: JORGE CHATO (651348)
 * =====================================================================================
 */
public class RecepieDAO {

    public void addRecepie(Recepie bean){
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        addRecepie(session,bean);
        tx.commit();
        session.close();
    }

    private void addRecepie(Session session, Recepie bean){
        Recepie recepie= new Recepie();

        recepie.setName(bean.getName());

        session.save(recepie);
    }

    public List<Recepie> getRecepies(){
        Session session = SessionUtil.getSession();
        String hql = "FROM recepies";
        Query query = session.createQuery(hql);
        List<Recepie> recepiesList =  query.list();
        session.close();

        return recepiesList;
    }

    public int deleteRecepie(int id) {
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

    public int updateRecepie(int id, Recepie rp){
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
