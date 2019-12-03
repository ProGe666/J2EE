package com.mercury.hibernateTests;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mercury.beans.User;
import com.mercury.utils.HibernateUtil;

public class Test6Criteria {

	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		Transaction t = session.beginTransaction();
		
		Criteria c = session.createCriteria(User.class);
		c.add(Restrictions.gt("age", 50)).add(Restrictions.like("name", "%e%"));
		
		List<User> users = c.list();
		
		users.forEach(u -> System.out.println(u));
		
		t.commit();
		HibernateUtil.closeSession();
	}

}
