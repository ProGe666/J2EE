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
	public void testGetById() {
		User jerry = ud.getById("Jerry");
		
		Assert.assertEquals("Jerry", jerry.getName());
		Assert.assertEquals(75, jerry.getAge());
	}
	
}
