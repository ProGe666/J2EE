package com.mercury.hibernateTests;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.beans.User;
import com.mercury.utils.HibernateUtil;

public class Test1States {

	// How many states does a hibernate object has?
	// 3 : transient, persistence / attached, detached
	
	public static void main(String[] args) {
		
		
		Session session = HibernateUtil.currentSession();
		Transaction t = session.beginTransaction();
		
		// transient object : no connection with the session
		User u = new User("Yolo", 12);
//		session.save(u);
		
		// persistence / attached
		User jerry = (User)session.get(User.class, "Jerry");
		System.out.println(jerry);
		
		User r = (User)session.get(User.class, "Rachel");
		r.setAge(19);
		u.setAge(22);
		
		System.out.println("**************");
		
		
		t.commit();
		HibernateUtil.closeSession();
		
		// detached
		System.out.println(jerry);
		jerry.setAge(100);
		
	}
}
