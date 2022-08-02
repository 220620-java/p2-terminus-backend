package com.revature.dummyapp.services;

import java.util.List;

import com.revature.dummyapp.models.Order;

/**
 * 
 * @author Devin
 * @author Tony Wiedman
 * @author Berhanu
 *
 */
public interface OrderService {

	/**
	 * 
	 * @param order
	 * @return
	 */
	Order saveOrder(Order order);

	/**
	 * 
	 * @param orderid
	 * @return
	 */
	Order getOrderById(long orderid);

	/**
	 * 
	 * @param customerid
	 * @return
	 */
	List<Order> getAllOrders();

	/**
	 * 
	 * @param order
	 * @param orderid
	 * @return
	 */
	Order updateOrder(Order order);

	/**
	 * 
	 * @param orderid
	 */
	void deleteOrder(long orderid);

}