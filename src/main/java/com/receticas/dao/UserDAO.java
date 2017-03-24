package com.receticas.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * =====================================================================================
 * Filename: UserDAO.java
 * Version: 1.0
 * Created: 3/24/17
 * Author: JORGE CHATO (651348)
 * =====================================================================================
 */
public class UserDAO {

    public void addUser(User bean){
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        addUser(session,bean);
        tx.commit();
        session.close();
    }

    private void addUser(Session session, User bean){
        User user= new User();

        user.setName(bean.getName());
        user.setPassword(bean.getPassword());

        session.save(user);
    }

    public List<User> getUsers(){
        Session session = SessionUtil.getSession();
        String hql = "FROM users";
        Query query = session.createQuery(hql);
        List<User> usersList =  query.list();
        session.close();

        return usersList;
    }

    public int deleteUser(long id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM users WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;
    }

    public int updateUser(long id, User rp){
        if(id <=0) return 0;

        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "UPDATE users SET name = :name, password = :password WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id",id);
        query.setParameter("name",rp.getName());
        query.setParameter("password",rp.getPassword());
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;
    }

    public User getUser(long id) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class, id);
        tx.commit();
        session.close();

        return user;
    }

    public User getUser(String name) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class, name);
        tx.commit();
        session.close();

        return user;
    }
}
