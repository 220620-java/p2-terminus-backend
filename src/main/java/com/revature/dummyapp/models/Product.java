package com.revature.dummyapp.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents the products a
 * Customer will be able to add to a cart and purchase
 * 
 * @author devin
 *
 */

@Entity //relates this class to the table in the database
@Table(name="products")
public class Product {
	/* Fields */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id")
	private long productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="stock_quantity")
	private int stockQuantity;
	
	@Column(name="product_price")
	private double price;
	
	/* Constructors */
	
	public Product() {
		this.productId = 0;
		this.productName = "";
		this.description = "";
		this.price = 0.0;
	}
	
	public Product(String name, String description, double price) {
		this.productId = 0;
		this.productName = name;
		this.description = description;
		this.price = price;
	}
	
	/* Public Methods (Getters & Setters) */
	
	/**
	 * 
	 * @return long product id
	 */
	public long getProductId() {
		return productId;
	}
	
	/**
	 * 
	 * @param productId
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * 
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return integer
	 */
	public int getStockQuantity() {
		return stockQuantity;
	}
	
	/**
	 * 
	 * @param stock_quantity
	 */
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	/**
	 * 
	 * @return double
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price (double)
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, price, productId, productName, stockQuantity);
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
		return Objects.equals(description, other.description)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& productId == other.productId && Objects.equals(productName, other.productName)
				&& stockQuantity == other.stockQuantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", stock_quantity=" + stockQuantity + ", price=" + price + "]";
	}


}
