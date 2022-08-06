package com.revature.dummyapp.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class represents the products a Customer will be able to add to a cart
 * and purchase
 * 
 * @author devin
 * @author Tony Wiedman
 * 
 */

@Entity
@Table(name = "products")
public class Product {

	@Id   
	@Column(name = "id")   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;

	@Column(name = "order_id")
	private long orderId;
	
	@Column(name = "endpoint")
	private String endpoint;


	public Product() {
		this.productId = 0;
		this.orderId = 0;
		this.endpoint = "";
	}

	public Product(long id, long orderId, String endpoint) {
		super();
		this.productId = id;
		this.orderId = orderId;
		this.endpoint = endpoint;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long id) {
		this.productId = id;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endpoint, productId, orderId);
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(endpoint, other.endpoint) && productId == other.productId && Objects.equals(orderId, other.orderId);
	}

	@Override
	public String toString() {
		return "Product [id=" + productId + ", orderId=" + orderId + ", endpoint=" + endpoint + "]";
	}

}
