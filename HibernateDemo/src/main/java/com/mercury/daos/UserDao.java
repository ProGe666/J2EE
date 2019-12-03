package com.mercury.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.beans.User;
import com.mercury.utils.HibernateUtil;

public class UserDao {

	public void save(User u) {
		
	}
	
	public List<User> getAll() {
		return null;
	}
	
	public User getById(String name) {
		Session session = HibernateUtil.currentSession();
		Transaction t = session.beginTransaction();
		
		
		// select name, age from SAMPLE where name = ?
		User u = (User)session.get(User.class, name);
		
		t.commit();
		HibernateUtil.closeSession();
		
		return u;
	}
}
