package com.mercury.hibernateTests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mercury.beans.User;

public class Test5SessionFactoryLevelCache {

	// session factory level cache will use 3rd party caching app
	// like ehcache, or Apache Ignite etc..
	// Sessions created from same session factory(most likely from 1 same app) will share
	
	// 2nd level cache
	
	public static void main(String[] args) {
		
		SessionFactory sf1 = new Configuration().configure().buildSessionFactory();
		SessionFactory sf2 = new Configuration().configure().buildSessionFactory();
		
		Session s1 = sf1.openSession();
		Transaction t1 = s1.beginTransaction();
		
		User m = (User)s1.get(User.class, "Maggie");
		m.setAge(70);
		System.out.println(m);
		
		t1.commit();
		s1.close();
		System.out.println("********");
	
		Session s2 = sf1.openSession();
		Transaction t2 = s2.beginTransaction();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		User m2 = (User)s2.get(User.class, "Maggie");
		System.out.println("in s2: " + m2);
		
		t2.commit();
		s2.close();
		
		System.out.println("**********");
		Session s3 = sf2.openSession();
		Transaction t3 = s3.beginTransaction();
		
		User m3 = (User)s3.get(User.class, "Maggie");
		System.out.println("in s3: " + m3);
		
		t3.commit();
		s3.close();
		
		System.out.println(m == m2);
		System.out.println(m == m3);
	}
}