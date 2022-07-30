package com.revature.dummyapp.services;

import java.util.List;
import java.util.Optional;

import com.revature.dummyapp.models.Order;

/**
 * 
 * @author Devin
 * @author Tony Wiedman
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
	List<Order> getAllOrders(long customerid);

	/**
	 * 
	 * @param order
	 * @param orderid
	 * @return
	 */
	Order updateOrder(Order order, long orderid);

	/**
	 * 
	 * @param orderid
	 */
	void deleteOrder(long orderid);

}