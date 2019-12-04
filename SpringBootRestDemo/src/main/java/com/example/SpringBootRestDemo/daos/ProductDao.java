package com.example.SpringBootRestDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SpringBootRestDemo.beans.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	//jpa standard
	public Product findByName(String name);
	
	
	//Not Jpa Standard
	//Jpa entity class
	//Product is a Jpa entity class
	//:price=====> place holder
	// this is JPQL
	@Query("select p from Product p where p.price = :price")
	
    Product getByPrice(@Param("price") int price);

	
}
