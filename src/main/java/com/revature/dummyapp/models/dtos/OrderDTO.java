package com.revature.dummyapp.models.dtos;

import java.util.Objects;

import com.revature.dummyapp.models.Order;

/**
 * Order DTO (Data Transfer Object) to prepare Order object to be sent in HTTP
 * response
 * 
 * @author Devin
 */
public class OrderDTO {
	private long orderId;
	private String orderDate;
	private double totalPrice;
	
	public OrderDTO() {
		this.orderId = 0;
		this.orderDate = "";
		this.totalPrice = 0.0;
	}
	
	public OrderDTO(long orderId, String orderDate, double totalPrice) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
	}
	
	public OrderDTO(Order order) {
		setOrderId(order.getOrderId());
		setOrderDate(order.getOrderDate());
		setTotalPrice(order.getTotalPrice());
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(orderDate, orderId, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDTO other = (OrderDTO) obj;
		return Objects.equals(orderDate, other.orderDate) && orderId == other.orderId
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + "]";
	}
	
	

}
