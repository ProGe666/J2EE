package com.example.SpringBootRestDemo.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MSI_ORDER")
public class Order {

	@Id
	@SequenceGenerator(name="msi_order_seq_gen",sequenceName= "MSI_ORDER_SEQ ",allocationSize =1)
	@GeneratedValue(generator = "msi_order_seq_gen",strategy = GenerationType.AUTO)
	private int id;
	@Column
	private Date purchase_date;
	@Column(name = "USER_ID")
	private int userID;
	//relationship
	//mapperBy ="order"
	//please make each OrderProduct.order field reference back to this order object
	@OneToMany(fetch = FetchType.EAGER, cascade =CascadeType.ALL, mappedBy ="order")
	private List<OrderProduct> purchases;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, Date purchase_date, int userID, List<OrderProduct> purchases) {
		super();
		this.id = id;
		this.purchase_date = purchase_date;
		this.userID = userID;
		this.purchases = purchases;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public List<OrderProduct> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<OrderProduct> purchases) {
		this.purchases = purchases;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", purchase_date=" + purchase_date + ", userID=" + userID + ", purchases="
				+ purchases + "]";
	}
	
}
