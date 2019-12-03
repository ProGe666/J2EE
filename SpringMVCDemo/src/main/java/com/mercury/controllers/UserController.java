package com.mercury.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.beans.User;

@Controller
@RequestMapping("/users")
public class UserController {

	// http://localhost:8080/SpringMVCDemo/users
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void save(@RequestBody User user) {
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAll() {
		
	}

	// http://localhost:8080/SpringMVCDemo/users/Greg
	
	@RequestMapping(value="/{name}",method = RequestMethod.GET)
	@ResponseBody
	public User getById(@PathVariable("name") String name) {
		
	}
	
	@RequestMapping(value="/saveBatch", method = RequestMethod.POST)
	@ResponseBody
	public void saveBatch(@RequestBody List<User> users) {
		
	}
	

	@RequestMapping(value="/age/{age}",method = RequestMethod.GET)
	@ResponseBody
	public User getByAge(@PathVariable("age") int age) {
		
	}
	

}
