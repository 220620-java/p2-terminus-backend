package com.revature.dummyapp.services;
import java.util.List;
import java.util.Optional;

import com.revature.dummyapp.models.Order;

public interface OrderService {

    Order saveOrder(Order order);
	Order getOrderById(long orderid);
	List<Order> getAllOrders(long customerid);
	Order updateOrder(Order order, long orderid);
	void deleteOrder(long orderid);


}