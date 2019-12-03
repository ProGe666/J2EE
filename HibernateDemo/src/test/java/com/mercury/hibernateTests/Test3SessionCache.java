package com.mercury.hibernateTests;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.beans.User;
import com.mercury.utils.HibernateUtil;

public class Test3SessionCache {
	
	// session cache : save attached object into session
	// 1st level cache : provided by Hibernate as a default feature

	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		Transaction t = session.beginTransaction();
		
		User j1 = (User)session.get(User.class, "Jerry");
		User j2 = (User)session.get(User.class, "Jerry");
		
		System.out.println(j1);
		System.out.println(j2);
		System.out.println(j1 == j2);
		
		t.commit();
		HibernateUtil.closeSession();
		
		/////////////////////////////////
		
		Session session2 = HibernateUtil.currentSession();
		Transaction t2 = session2.beginTransaction();
		
		User j3 = (User)session2.get(User.class, "Jerry");
		System.out.println(j3);
		System.out.println(j1 == j3);
		
		t2.commit();
		HibernateUtil.closeSession();
		
	}
}
