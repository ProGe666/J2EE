package com.mercury.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mercury.beans.User;
import com.mercury.utils.HibernateUtil;

public class UserDao {

	public void save(User user) {
		
	}
	
	public User getByName(String name) {
		Session session = HibernateUtil.currentSession();
		Transaction t = session.beginTransaction();
		
		User u = (User)session.get(User.class, name);
		
		t.commit();
		HibernateUtil.closeSession();
		
		return u;
	}
	
	public List<User> getAll() {
		List<User> users = new ArrayList();
		
		
		return users;
	}
}
