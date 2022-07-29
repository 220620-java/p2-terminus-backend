package com.revature.dummyapp.services;
import java.util.List;

import com.revature.dummyapp.models.Order;

public interface OrderService {

    Order saveOrder(Order order);
	List<Order> getAllOrders();
	Order getOrderById(long orderid);
	Order updateOrder(Order order, long orderid);
	void deleteOrder(long orderid);


}