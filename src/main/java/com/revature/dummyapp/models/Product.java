package com.revature.dummyapp.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * This class represents the products a Customer will be able to add to a cart
 * and purchase
 * 
 * @author devin
 * @author Tony Wiedman
 * 
 */

@Entity // relates this class to the table in the database
@Table(name = "products")
public class Product {
	/* Fields */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "endpoint")
	private String endpoint;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id", insertable=true, updatable=true)
	protected Order order;

	/* Constructors */

	public Product() {
		this.id = 0;
		this.endpoint = "";
	}

	public Product(long id, String endpoint, int orderId) {
		super();
		this.id = id;
		this.endpoint = endpoint;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}


	@Override
	public int hashCode() {
		return Objects.hash(endpoint, id);
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
		return Objects.equals(endpoint, other.endpoint) && id == other.id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", endpoint=" + endpoint + "]";
	}



}
