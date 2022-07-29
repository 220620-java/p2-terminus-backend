<<<<<<< HEAD:src/main/java/com/revature/dummyapp/services/OrderServiceImp.java
package com.revature.dummyapp.services;
=======
package com.revature.dummyapp.services.impl;
>>>>>>> cb1e50a3ad9c79434cf4a166b81c06ee64dba329:src/main/java/com/revature/dummyapp/services/impl/OrderServiceImp.java
import com.revature.dummyapp.services.OrderService;
import java.util.List;
import org.springframework.stereotype.Service;
import com.revature.dummyapp.data.OrderRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.models.Order;


@Service
public class OrderServiceImp implements OrderService {

    private OrderRepository orderRepository;

    
	
	public OrderServiceImp(OrderRepository orderRepository) {

		super();

		this.orderRepository = orderRepository;
	}

	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(long orderid) {
 
		return orderRepository.findById(orderid).orElseThrow(() -> 
						new NotFoundException("Order", "orderid", orderid));
		
	}

@Override
	public Order updateOrder(Order order, long orderid) {
<<<<<<< HEAD:src/main/java/com/revature/dummyapp/services/OrderServiceImp.java
		Long id = order.getProductid();
=======
		
>>>>>>> cb1e50a3ad9c79434cf4a166b81c06ee64dba329:src/main/java/com/revature/dummyapp/services/impl/OrderServiceImp.java
		// we need to check whether user with given id is exist in DB or not
		Order existingOrder = orderRepository.findById(orderid).orElseThrow(
				() -> new NotFoundException("Order", "orderid", orderid)); 
		
<<<<<<< HEAD:src/main/java/com/revature/dummyapp/services/OrderServiceImp.java

		if(order.getProductid() > -1) {
			existingOrder.setProductid(order.getProductid());
		}
		if(order.getOrderdate()!= null) {
			existingOrder.setOrderdate(order.getOrderdate());
		}
		if(order.getTotalPrice() != null) {
			existingOrder.setTotalPrice(order.getTotalPrice());
=======
		if(order.getProductId() !=-1) {
			existingOrder.setProductId(order.getProductId());
		}
		if(order.getOrderDate()!= null) {
			existingOrder.setOrderDate(order.getOrderDate());
		}
		if(order.getTotalPriceString() != null) {
			existingOrder.setTotalPrice(order.getTotalPriceString());
>>>>>>> cb1e50a3ad9c79434cf4a166b81c06ee64dba329:src/main/java/com/revature/dummyapp/services/impl/OrderServiceImp.java
		}
		
		
		
		
		// save existing user to DB
		orderRepository.save(existingOrder);
		return existingOrder;
	}

	@Override
	public void deleteOrder(long orderid) {
		
		// check whether a user exist in a DB or not
		orderRepository.findById(orderid).orElseThrow(() -> 
								new NotFoundException("Order", "order", orderid));
                                orderRepository.deleteById(orderid);
	}
}