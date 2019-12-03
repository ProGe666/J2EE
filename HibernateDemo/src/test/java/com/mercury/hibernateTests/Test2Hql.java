package com.mercury.hibernateTests;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.beans.User;
import com.mercury.utils.HibernateUtil;

public class Test2Hql {

	public static void main(String[] args) {
		// SQL : Structured Query Language
		// HQL : Hibernate Query Language

		Session session = HibernateUtil.currentSession();
		Transaction t = session.beginTransaction();
		
		// User is the class, case sensitive
		String hql = "fRom User";
		Query query = session.createQuery(hql);
		
		// return only 1 record from DB
		// exception out if more than 1 row are found
//		query.uniqueResult();
		
		// put all return into a list
		List<User> users = query.list();
		
		users.forEach(u -> System.out.println(u));
		
		t.commit();
		HibernateUtil.closeSession();
		
		
	}
}
