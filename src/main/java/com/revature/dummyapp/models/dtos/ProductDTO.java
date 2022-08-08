package com.revature.dummyapp.models.dtos;

import com.revature.dummyapp.models.Product;

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
 * 
 */
public class ProductDTO {
	/* Fields */
	
	private long productId;
	private long orderId;
	private String endpoint;
	
	/* Constructors */

	public ProductDTO(long id, long orderId, String endpoint) {
		super();
		this.productId = id;
		this.orderId = orderId;
		this.endpoint = endpoint;
	}

	public ProductDTO(Product product) {
		setProductId(product.getProductId());
		setOrderId(product.getOrderId());
		setEndpoint(product.getEndpoint());
	}
	
	/* Public Methods (Getters and Setters) */

	public long getProductId() {
		return productId;
	}

	public void setProductId(long id) {
		this.productId = id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

}