package com.example.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootRestDemo.beans.OrderProduct;

public interface OrderProductDao extends JpaRepository<OrderProduct, Integer> {

	
}
