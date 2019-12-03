package com.mercury.services;

import com.mercury.beans.User;
import com.mercury.daos.UserDao;

public class TrainingService {
	
	public UserDao ud = new UserDao();
	
	public User pick(String name) {
		return null;
	}
	
	public void train() {
		ud.getAll();
		
	}
}
