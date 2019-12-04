package com.example.SpringBootRestDemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.SpringBootRestDemo.daos.UserDao;

public class UserDetailsServicelmpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		User u= userDao.findByUsername(username);//相当于hilbernate 的get Function

		if(u ==null){
			throw new UsernameNotFoundException("User name not exist");
		}
		
		return u;
	}
}
