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
		//1. 创建一个 SessionFactory 对象 
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder() .configure("hibernate.cfg.xml").build(); 
		Metadata metadata = new MetadataSources(standardRegistry) .getMetadataBuilder().build();
		SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder(); 
		SessionFactory sessionFactory = sessionFactoryBuilder.build(); 
		//2. 创建一个 Session 对象 
		Session session = sessionFactory.openSession();
		//3. 开启事务 
		Transaction transaction = session.beginTransaction(); 
	
		//4. 执行保存操作
		Test test = new Test(1522, "Jackic", 88f);
		session.save(test);
		
		//5. 提交事务
		transaction.commit();
		//6. 关闭Session 
		session.close(); 
		//7. 关闭 SessionFactory 对象 
		sessionFactory.close();
	}
	
}
