package com.example.SpringBootRestDemo.daos;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer>{
	User findByUsername(String username);

}
