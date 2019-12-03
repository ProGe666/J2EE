package com.mercury.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mercury.beans.User;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/foo")
	@ResponseBody
	public void foo() {
		System.out.println("foo...");
	}
	
	@RequestMapping(value="/bar", method=RequestMethod.GET)
	@ResponseBody			// put the return value into response body
	public String bar() {
		System.out.println("bar...");
		return "bar";
	}
	
	@RequestMapping("/test")
	public ModelAndView test() {
		System.out.println("test...");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/showName")
	@ResponseBody
	public String showName(@RequestParam("name") String n, @RequestParam("age") int age) {
		// @RequestParam : get the param from request parameter part
		System.out.println(n);
		return "Received name: " + n;
	}
	
	@RequestMapping("/anotherName/{aName}/{x}")
	@ResponseBody
	public String anotherName(@PathVariable("aName") String n, @PathVariable("x") String x) {
		// @RequestParam : get the param from request parameter part
		System.out.println(n);
		return "Another name: " + n;
	}
	
	@RequestMapping("/me")
	@ResponseBody
	public User getMe(@RequestBody User u) {
		System.out.println("me...");
		return u;
	}
}
