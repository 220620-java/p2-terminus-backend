package com.revature.dummyapp.models;
<<<<<<< HEAD

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

@Entity
@Table(name= "orders")
=======
import javax.persistence.Table;

@Entity
@Table(name= "order")
>>>>>>> cb1e50a3ad9c79434cf4a166b81c06ee64dba329
public class Order {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
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
		return Objects.equals(orderdate, other.orderdate) && orderid == other.orderid && productid == other.productid
				&& Objects.equals(products, other.products) && Objects.equals(totalPrice, other.totalPrice);
	}
	

	
	
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

    
}
