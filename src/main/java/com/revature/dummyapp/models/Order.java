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
	private long orderid;

	@Column(name = "order_date")
	private String orderdate;

	@Column(name = "total_price")
	private Double totalPrice;

	@OneToMany
	@JoinColumn(name = "order_id")
	private List<Product> products;

	public Order() {
		super();
		this.orderid = 0;
		this.orderdate = "";
		this.totalPrice = 0.0;
		this.products = new ArrayList<>();
	}

	public Order(long orderid, String orderdate, Double totalPrice, List<Product> products) {
		super();
		this.orderid = orderid;
		this.orderdate = orderdate;
		this.totalPrice = totalPrice;
		this.products = products;
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
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
		return Objects.hash(orderdate, orderid, products, totalPrice);
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
		return Objects.equals(orderdate, other.orderdate) && orderid == other.orderid
				&& Objects.equals(products, other.products) && Objects.equals(totalPrice, other.totalPrice);
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", orderdate=" + orderdate + ", totalPrice=" + totalPrice + ", products="
				+ products + "]";
	}

}
