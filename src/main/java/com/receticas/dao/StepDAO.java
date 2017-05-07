package com.receticas.dao;

import com.receticas.models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StepDAO{

	public void addStep(Step bean){
		Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        addStep(session,bean);
        tx.commit();
        session.close();
	}

	private void addStep(Session session, Step bean){
        Step step = new Step();
        step.setStep(bean.getStep());
        step.setTime(bean.getTime());
        step.setInformation(bean.getInformation());


        session.save(step);
    }

    public List<Step> getSteps(){
    	Session session = SessionUtil.getSession();
    	String hql="FROM steps GROUP BY recipe ORDER BY step ASC";
    	Query query = session.createQuery(hql);
        List<Step> stepList = query.list();
        session.close();

        return stepList;
    }

    public Step getStep(PkStep id){
    	Session session= SessionUtil.getSession();
    	Transaction tx = session.beginTransaction();
    	Step step= session.get(Step.class,id);
    	tx.commit();
    	session.close();

    	return step;
    }

    public int deleteStep(PkStep id){
    	Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM steps WHERE step = :step and recipe= :recipe";
        Query query = session.createQuery(hql);
    	query.setParameter("step",id.getStep());
    	query.setParameter("recipe",id.getRecipe());
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;    
    }

    public int updateStep(PkStep id, Step step){
    	if(id.getStep() <=0) return 0;
    	Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "UPDATE steps SET step = :step, time = :time, information = :information WHERE step = :step and recipe = :recipe";
        Query query = session.createQuery(hql);
        query.setParameter("step",id.getStep());
    	query.setParameter("recipe",id.getRecipe());
        query.setParameter("name",step.getStep());
        query.setParameter("time",step.getTime());
        query.setParameter("information",step.getInformation());
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();

        return rowCount;

    }
}