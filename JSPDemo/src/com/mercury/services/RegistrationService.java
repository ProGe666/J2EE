package com.mercury.services;

import com.mercury.beans.User;
import com.mercury.daos.UserDao;

public class RegistrationService {

	private UserDao ud = new UserDao();
	
	public void register(String name, int age) {
		ud.save(new User(name, age));
	}
}
