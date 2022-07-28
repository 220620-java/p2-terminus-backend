package com.revature.dummyapp.models;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "order")
public class Order {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(productid, other.productid)  && Objects.equals(orderdate, other.orderdate)   
				&& Objects.equals(totalPrice, other.totalPrice);
	}

	@Override
	public String toString() {
		return "order [orderid=" + orderid + ", productid=" + productid + ",orderdate= " + orderdate + ", totalprice=" + totalPrice + ","
				+ "]";
	}

    
}
