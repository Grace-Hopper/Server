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

    public int deleteUser(String name) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM users WHERE  name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
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
        String hql = "UPDATE users SET password = :password WHERE name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", rp.getName());
        query.setParameter("password", rp.getPassword());
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;
    }

    public User getUser(String name) {
        Session session = SessionUtil.getSession();
        String hql = "FROM users WHERE name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        User user = (User) query.uniqueResult();
        session.close();

        return user;
    }
}
