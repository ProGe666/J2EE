package com.mercury.hibernateTests;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.beans.User;
import com.mercury.utils.HibernateUtil;

public class Test4GetLoad {

	public static void main(String[] args) {
		
		// get() is eager
		// load() is lazy
		
		Session session = HibernateUtil.currentSession();
		Transaction t = session.beginTransaction();
		
		// both use session cache
		// if session contains the object, both function will directly return it
		
		// if the record does not exist in database
		// get() will return null, load() exception out
		// So, load() should always surrounded with try-catch
		
		User tom = (User)session.get(User.class, "Tommy");
		User jerry = (User)session.load(User.class, "Tommy");
		
		System.out.println("****************");
		
//		System.out.println(tom.getClass().getName());
		System.out.println(jerry.getClass().getName());
		
		System.out.println("****************");
		
		System.out.println(tom);
		System.out.println(jerry.toString());
		
		
		t.commit();
		HibernateUtil.closeSession();

	}
}
