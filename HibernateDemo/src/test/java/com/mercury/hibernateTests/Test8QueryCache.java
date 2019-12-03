package com.mercury.hibernateTests;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.beans.User;
import com.mercury.utils.HibernateUtil;

public class Test8QueryCache {

	public static void main(String[] args) {
		// query cache will also save into the cache app (ehcache)
		
		Session session = HibernateUtil.currentSession();
		Transaction t = session.beginTransaction();
		
		String hql = "fRom User";
		Query query = session.createQuery(hql);
		
		query.setCacheable(true);
		
		List<User> users1 = query.list();
		users1.forEach(u -> System.out.println(u));
		
		List<User> users2 = query.list();
		users2.forEach(u -> System.out.println(u));
		
		t.commit();
		HibernateUtil.closeSession();
	}
}
