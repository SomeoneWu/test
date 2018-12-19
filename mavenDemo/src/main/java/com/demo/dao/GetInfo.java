package com.demo.dao;

import org.hibernate.SessionFactory;

import com.demo.entity.Test;

public class GetInfo {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("deprecation")
	public Test quaryByID(Integer Id) {
		Test test = (Test)sessionFactory.getCurrentSession().createQuery
		("select * from test where id = ?").setInteger(0, Id).uniqueResult();
		
		return test;
	}
	
	
}
