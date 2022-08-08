package com.revature.dummyapp.models.dtos;

import com.revature.dummyapp.models.Order;

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
 * 
 */
public class OrderDTO {
	/* Fields */
	
	private long orderId;
	private long customerId;
	private String orderDate;
	private double totalPrice;
	
	/* Constructors */
	
	public OrderDTO(long orderId, String orderDate, double totalPrice, long customerId) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}
	
	public OrderDTO(Order order) {
		setOrderId(order.getOrderId());
		setOrderDate(order.getOrderDate());
		setTotalPrice(order.getTotalPrice());
	}
	
	/* Public Methods (Getters and Setters) */

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

}
