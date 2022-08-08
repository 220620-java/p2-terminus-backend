package com.revature.dummyapp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.data.OrderRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.models.Order;
import com.revature.dummyapp.services.OrderService;

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
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
		order = orderRepo.save(order);
		return order;
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
		if (orderRepo.findById(order.getOrderId()).isPresent()) {
			orderRepo.save(order);

			Optional<Order> orderOpt = orderRepo.findById(order.getOrderId());
			if (orderOpt.isPresent())
				return orderOpt.get();

		}
		return null;
	}

	@Override
	public void deleteOrder(long id) throws NotFoundException {
		Optional<Order> order = orderRepo.findById(id);
        if (order.isPresent()) {
        	orderRepo.deleteById(id);
        } else {
            throw new NotFoundException("Order", "Id", id);
        }
	}

}
