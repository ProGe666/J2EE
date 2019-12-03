package com.mercury.services;

import java.util.List;

import com.mercury.beans.User;
import com.mercury.daos.UserDao;

public class TrainingService {
	
	public UserDao ud = new UserDao();
	
	public User pick(String name) {
		return ud.getById(name);
	}
	
	public List<User> train() {
		return ud.getAll();
	}
}
