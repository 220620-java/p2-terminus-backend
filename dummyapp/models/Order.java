package com.revature.dummyapp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long orderId;
	
	@Column(name = "customer_id")
	private String customerId;
	
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(orderDate, other.orderDate)
				&& orderId == other.orderId && Objects.equals(products, other.products)
				&& Objects.equals(totalPrice, other.totalPrice);
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate + ", totalPrice="
				+ totalPrice + ", products=" + products + "]";
	}

}
