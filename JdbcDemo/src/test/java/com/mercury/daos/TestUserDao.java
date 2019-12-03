package com.mercury.daos;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mercury.beans.User;

import junit.framework.Assert;

public class TestUserDao {
	private UserDao ud;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ud = new UserDao();
	}

	@Test
	public void testGetAll() {
		List<User> users = ud.getAll();
		
		// spot check
		boolean neoExist = false;
		boolean tomExist = false;
		
		for(User u : users) {
			if(u.getName().equals("Neo") && u.getAge() == 20) {
				neoExist = true;
			} else if(u.getName().equals("Tom") && u.getAge() == 80) {
				tomExist = true;
			}
		}
		
		Assert.assertEquals(true, neoExist);
		Assert.assertTrue(tomExist);
	}

	
	@Test
	public void testGetById() {
		User jerry = ud.getById("Jerry");
		
		Assert.assertEquals("Jerry", jerry.getName());
		Assert.assertEquals(75, jerry.getAge());
	}
	
	@Test
	public void testSave() {
		User rachel = new User("Rachel", 9);
		ud.save(rachel);
		
		User rachelInDb = ud.getById("Rachel");
		Assert.assertEquals("Rachel", rachelInDb.getName());
		Assert.assertEquals(9, rachelInDb.getAge());
	}
}
