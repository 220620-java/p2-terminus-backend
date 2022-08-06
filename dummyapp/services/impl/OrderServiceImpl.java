package com.revature.dummyapp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.data.OrderRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.models.Order;
import com.revature.dummyapp.services.OrderService;

/**
 * 
 * @author Devin
 * @author Tony Wiedman
 * @author Berhanu
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	private OrderRepository orderRepo;
	
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepo = orderRepository;
	}
	
	@Override
	public Order saveOrder(Order order) {
		// log.info("Saving new order with id: {}", order.getOrderId());
		return orderRepo.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order getOrderById(long id) {
		Optional<Order> order = orderRepo.findById(id);
		if (order.isPresent()) {
			return order.get();
		} else {
			throw new NotFoundException("Customer", "Id", id);
		}
	}

	@Override
	public Order updateOrder(Order order) {
			Order existingOrder = orderRepo.findById(order.getOrderId())
					.orElseThrow(() -> new NotFoundException("Customer", "customerid", order.getOrderId()));

			if (order.getOrderDate() != null) {
				existingOrder.setOrderDate(order.getOrderDate());
			}
			if (order.getTotalPrice() != null) {
				existingOrder.setTotalPrice(order.getTotalPrice());
			}
			if (order.getProducts() != null) {
				existingOrder.setProducts(order.getProducts());
			}

			orderRepo.save(existingOrder);
			return existingOrder;
	}

	@Override
	public void deleteOrder(long id) {
		orderRepo.findById(id).orElseThrow(() -> new NotFoundException("Order", "orderid", id));
		orderRepo.deleteById(id);
	}

}
