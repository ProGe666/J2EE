package com.example.SpringBootRestDemo.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringBootRestDemo.beans.Order;
import com.example.SpringBootRestDemo.beans.OrderProduct;
import com.example.SpringBootRestDemo.beans.Product;
import com.example.SpringBootRestDemo.daos.OrderDao;
import com.example.SpringBootRestDemo.daos.OrderProductDao;
import com.example.SpringBootRestDemo.daos.ProductDao;
import com.example.SpringBootRestDemo.http.Response;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    
    @Autowired
    private ProductDao productDao;
    
    @Autowired
    private OrderProductDao orderProductDao;
    
    public List<Order> getAll(){
        return orderDao.findAll();
    }
    
    public Order getOrderById(Integer id) {
        return orderDao.findById(id).get();
    }
    //Spring transaction will rollback only if the function is exception out
    //try-catch will handle the exception and make it success, no exception
    @Transactional(isolation =Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Response save(Order order) {
        try {
            List<OrderProduct> purchases = order.getPurchases();
            purchases.forEach((orderProduct) -> {
                // enrich the product object
                Product product = (Product) productDao.findById(orderProduct.getProduct().getId()).get();
                orderProduct.setProduct(product);
                
                orderProduct.setOrder(order);
            });
            orderDao.save(order);
            
            return new Response(true);
        } catch (Exception e) {
            //return new Response(false);
            throw new NullPointerException();
            //this will roll back.
            //roll back only roll back current transaction
        }
    }
    
    public Response edit(Order order) {
        try {
            Order o = (Order) orderDao.findById(order.getId()).get();
            List<OrderProduct> purchasesToRemove = o.getPurchases();
            
            List<OrderProduct> purchases = order.getPurchases();
            // handled update and add products in order
            purchases.forEach((orderProduct) -> {
                Product product = (Product) productDao.findById(orderProduct.getProduct().getId()).get();
                orderProduct.setProduct(product);
                orderProduct.setOrder(o);
            });
            
            // handle remove products in order
            if(purchases.size() > 0) {
                purchasesToRemove = purchasesToRemove.stream().filter((orderProduct) -> {
                    return !purchases.contains(orderProduct);
                }).collect(Collectors.toList());
            }
            
            o.setPurchases(purchases);
            orderDao.save(o);
            
            deleteOrderProducts(purchasesToRemove); 
                        
            return new Response(true);
        } catch (Exception e) {
            System.out.println(e);
            return new Response(false);
        }
    }
    
    public void deleteOrderProducts(List<OrderProduct> purchases) {
        orderProductDao.deleteAll(purchases);   
    }
}





