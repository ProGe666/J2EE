package com.example.SpringBootRestDemo.daos;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootRestDemo.beans.Order;

public interface OrderDao extends JpaRepository<Order,Integer> {

}
