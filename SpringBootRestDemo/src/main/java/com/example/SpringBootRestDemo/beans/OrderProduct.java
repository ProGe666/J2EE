package com.example.SpringBootRestDemo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MSI_ORDER{RODUCT")
public class OrderProduct {
	@Id
	@SequenceGenerator(name="msi_order_product_seq_gen",sequenceName= "MSI_ORDER_PRODUCT_SEQ ",allocationSize =1)
	@GeneratedValue(generator = "msi_order_product_seq_gen",strategy = GenerationType.AUTO)
	private int id;
	@Column
	private int qty;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade =CascadeType.DETACH)
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	
	@ManyToOne(fetch = FetchType.EAGER,cascade =CascadeType.DETACH)
	@JoinColumn(name = "PRODUCT_ID")
	//producte id is int the Orderproduct file
	private Product product;
	public OrderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderProduct(int id, int qty, Order order, Product product) {
		super();
		this.id = id;
		this.qty = qty;
		this.order = order;
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@JsonIgnore
	public Order getOrder() {
		return order;
	}
	//@JsonIgnore :拒收Order field
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", qty=" + qty + ", order=" + order + ", product=" + product + "]";
	}
	
	
}
