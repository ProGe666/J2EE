package com.mercury.services;

import com.mercury.beans.User;
import com.mercury.daos.UserDao;

public class TrainingService {

	private UserDao ud = new UserDao();
	
	public void calculateScoreAndSave(User u) {
		// calculate score...
		ud.save(u);
	}
	
	public void answerQuestion(String questions, User u) {
		// logic
	}
}
