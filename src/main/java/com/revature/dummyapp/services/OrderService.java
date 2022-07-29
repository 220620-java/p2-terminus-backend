package com.revature.dummyapp.services;
import java.util.List;

import com.revature.dummyapp.models.Order;

public interface OrderService {
    
    Order saveOrder( Order  order);
	List<Order> getAllOrders();
	Order getOrderById(long orderid);
	Order updateOrder(Order order, long orderid);
	void deleteOrder(long orderid);


<<<<<<< HEAD
}
=======
}
>>>>>>> cb1e50a3ad9c79434cf4a166b81c06ee64dba329
