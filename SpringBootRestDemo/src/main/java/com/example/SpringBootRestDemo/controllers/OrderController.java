package com.example.SpringBootRestDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootRestDemo.beans.Order;
import com.example.SpringBootRestDemo.http.Response;
import com.example.SpringBootRestDemo.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public List<Order> getAll() {
		return orderService.getAll();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public Order getById(@PathVariable int id) {
		return orderService.getOrderById(id);
	}
	
	@PostMapping
	public Response save(@RequestBody Order order) {
		return orderService.save(order);
	}
	
}



