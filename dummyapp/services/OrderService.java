package com.revature.dummyapp.services;
<<<<<<< HEAD
=======

>>>>>>> main
import java.util.List;

import com.revature.dummyapp.models.Order;

<<<<<<< HEAD
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
=======
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
>>>>>>> main
