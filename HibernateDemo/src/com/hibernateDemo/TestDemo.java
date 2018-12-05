package com.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestDemo {
	
	public static void main(String args[]) {
		//1. ����һ�� SessionFactory ���� 
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder() .configure("hibernate.cfg.xml").build(); 
		Metadata metadata = new MetadataSources(standardRegistry) .getMetadataBuilder().build();
		SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder(); 
		SessionFactory sessionFactory = sessionFactoryBuilder.build(); 
		//2. ����һ�� Session ���� 
		Session session = sessionFactory.openSession();
		//3. �������� 
		Transaction transaction = session.beginTransaction(); 
	
		//4. ִ�б������
		Test test = new Test(1522, "Jackic", 88f);
		session.save(test);
		
		//5. �ύ����
		transaction.commit();
		//6. �ر�Session 
		session.close(); 
		//7. �ر� SessionFactory ���� 
		sessionFactory.close();
	}
	
}
