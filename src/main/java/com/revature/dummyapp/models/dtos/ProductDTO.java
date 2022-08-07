package com.revature.dummyapp.models.dtos;

import java.util.Objects;

import com.revature.dummyapp.models.Product;

public class ProductDTO {
	private long productId;
	private long orderId;
	private String endpoint;

	public ProductDTO() {
		this.productId = 0;
		this.orderId = 0;
		this.endpoint = "";
	}

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

	@Override
	public String toString() {
		return "ProductDTO [id=" + productId + ", orderId=" + orderId + ", endpoint=" + endpoint + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(endpoint, productId, orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		return Objects.equals(endpoint, other.endpoint) && productId == other.productId && orderId == other.orderId;
	}

}