package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Test;

@Transactional
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
		Session session = sessionFactory.getCurrentSession();
		
		Test test = (Test)session.createQuery("from Test where id=?").setInteger(0, Id).uniqueResult();
		
		return test;
	}
	
	
}
