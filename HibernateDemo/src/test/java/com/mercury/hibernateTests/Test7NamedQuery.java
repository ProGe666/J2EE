package com.mercury.hibernateTests;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.beans.User;
import com.mercury.utils.HibernateUtil;

public class Test7NamedQuery {

	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		Transaction t = session.beginTransaction();
		
		Query query = session.getNamedQuery("userQuery");
		query.setInteger("age", 50);
		
		List<User> users = query.list();
		
		users.forEach(u -> System.out.println(u));
		
		t.commit();
		HibernateUtil.closeSession();
	}
}
