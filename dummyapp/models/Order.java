package com.revature.dummyapp.models;
<<<<<<< HEAD

import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> cb1e50a3ad9c79434cf4a166b81c06ee64dba329
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Tony Wiedman
 * @author Devin
 * @author Berhanu
 *
 */
@Entity
<<<<<<< HEAD
@Table(name= "orders")
=======
import javax.persistence.Table;

@Entity
@Table(name= "order")
>>>>>>> cb1e50a3ad9c79434cf4a166b81c06ee64dba329
=======
@Table(name = "orders")
>>>>>>> main
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
<<<<<<< HEAD
    @Column(name = "order_id")
	private long orderid;
=======
	@Column(name = "id")
	private long orderId;
>>>>>>> main
	
	@Column(name = "customer_id")
	private long customerId;
	
	@Column(name = "order_date")
	private String orderDate;

	@Column(name = "total_price")
	private Double totalPrice;

	@OneToMany
	@JoinColumn(name = "order_id")
	private List<Product> products;

	public Order() {
		super();
		this.orderId = 0;
		this.orderDate = "";
		this.totalPrice = 0.0;
		this.products = new ArrayList<>();
	}

	public Order(long orderid, String orderdate, Double totalPrice, List<Product> products) {
		super();
		this.orderId = orderid;
		this.orderDate = orderdate;
		this.totalPrice = totalPrice;
		this.products = products;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderid) {
		this.orderId = orderid;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderdate) {
		this.orderDate = orderdate;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, orderDate, orderId, products, totalPrice);
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	@Override
=======
	private long orderid;
	
	@Column(name = " productid")
	private long productid;
	
    @Column(name = "orderdate")
	private String orderdate;
	
	@Column(name = "totalprice")
	private Double totalPrice;
	
    public long getOrderId() {
		return orderid;
	}
	public void setorderid(long orderid) {
		this.orderid = orderid;
	}
    public long getProductId() {
		return productid;
	}
	public void setProductId(long productid) {
		this.productid = productid;
	}
    public String getOrderDate() {
		return orderdate;
	}
	public void setOrderDate(String orderdate) {
		this.orderdate = orderdate;
	}
    public Double getTotalPriceString() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
    @Override
>>>>>>> cb1e50a3ad9c79434cf4a166b81c06ee64dba329
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
<<<<<<< HEAD
<<<<<<< HEAD
		return Objects.equals(orderdate, other.orderdate) && orderid == other.orderid && productid == other.productid
				&& Objects.equals(products, other.products) && Objects.equals(totalPrice, other.totalPrice);
=======
		return Objects.equals(customerId, other.customerId) && Objects.equals(orderDate, other.orderDate)
				&& orderId == other.orderId && Objects.equals(products, other.products)
				&& Objects.equals(totalPrice, other.totalPrice);
>>>>>>> main
	}

<<<<<<< HEAD
	
	
=======
		return Objects.equals(productid, other.productid)  && Objects.equals(orderdate, other.orderdate)   
				&& Objects.equals(totalPrice, other.totalPrice);
	}

	@Override
	public String toString() {
		return "order [orderid=" + orderid + ", productid=" + productid + ",orderdate= " + orderdate + ", totalprice=" + totalPrice + ","
				+ "]";
	}
>>>>>>> cb1e50a3ad9c79434cf4a166b81c06ee64dba329
=======
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate + ", totalPrice="
				+ totalPrice + ", products=" + products + "]";
	}
>>>>>>> main

}
