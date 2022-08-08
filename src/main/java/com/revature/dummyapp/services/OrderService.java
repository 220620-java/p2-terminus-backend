package com.revature.dummyapp.services;

import java.util.List;

import com.revature.dummyapp.models.Order;

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
 * 
 */
public interface OrderService {

	/**
	 * Saves a new order in the database
	 * 
	 * @param order
	 * @return
	 */
	Order saveOrder(Order order);

	/**
	 * Retrieves an order from the database
	 * based on order id
	 * 
	 * @param orderid
	 * @return
	 */
	Order getOrderById(long orderid);

	/**
	 * retrieves a list of all orders in the database
	 * 
	 * @return
	 */
	List<Order> getAllOrders();

	/**
	 * 
	 * 
	 * @param order
	 * @return
	 */
	Order updateOrder(Order order);

	/**
	 * Removes an order from the database based on id
	 * 
	 * @param orderid
	 */
	void deleteOrder(long orderid);

}