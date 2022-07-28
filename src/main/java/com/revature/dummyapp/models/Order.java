package com.revature.dummyapp.models;

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

@Entity
@Table(name= "orders")
public class Order {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
	private long orderid;
	
	@Column(name = "product_id")
	private long productid;
	
    @Column(name = "order_date")
	private String orderdate;
	
	@Column(name = "total_price")
	private Double totalPrice;
	
	@OneToMany
	@JoinColumn(name="product_id")
	private List<Product> products;

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	public long getProductid() {
		return productid;
	}

	public void setProductid(long productid) {
		this.productid = productid;
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
	public String toString() {
		return "Order [orderid=" + orderid + ", productid=" + productid + ", orderdate=" + orderdate + ", totalPrice="
				+ totalPrice + ", products=" + products + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderdate, orderid, productid, products, totalPrice);
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
		return Objects.equals(orderdate, other.orderdate) && orderid == other.orderid && productid == other.productid
				&& Objects.equals(products, other.products) && Objects.equals(totalPrice, other.totalPrice);
	}
	

	
	

    
}
