package com.receticas.dao;

import com.receticas.models.User;
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
        User user= new User(bean.getName(), bean.getPassword());

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

    public int deleteUser(String token) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM users WHERE token = :token";
        Query query = session.createQuery(hql);
        query.setParameter("token",token);
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
        String hql = "UPDATE users SET name = :name, password = :password WHERE token = :token";
        Query query = session.createQuery(hql);
        query.setParameter("token", rp.getToken());
        query.setParameter("name", rp.getName());
        query.setParameter("password", rp.getPassword());
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;
    }

    public User getUser(String token) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class, token);
        tx.commit();
        session.close();

        return user;
    }
}
