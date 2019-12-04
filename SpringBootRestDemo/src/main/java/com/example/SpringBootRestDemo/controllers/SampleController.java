package com.example.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootRestDemo.beans.Sample;

@RestController //controller+response body
@RequestMapping("/samples")
public class SampleController {

	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping()
	
	public void save(@RequestBody Sample sample){
		
	}
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping()
	
	public List<Sample> getAll(){
		return null;
	}
	//@RequestMapping(value="/{name}",method = RequestMethod.GET)
	
	@GetMapping("/{name}")
	public Sample getById(@PathVariable("name") String name){
		return new Sample(name,10);
	}
	
	@Cacheable("abc")
	@GetMapping("/c1/{x}")
	public int calculate(@PathVariable int x){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x*10;
	}
	@Cacheable("abc")
	@GetMapping("/c2/{x}")
	public int calculate2(@PathVariable int x){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x*10;
	}
	
}
