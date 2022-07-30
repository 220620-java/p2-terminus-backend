package com.revature.dummyapp.services.impl;

import java.util.List;
import java.util.Optional;

import com.revature.dummyapp.data.OrderRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.models.Order;
import com.revature.dummyapp.services.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderRepository orderRepo;
	
	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepo = orderRepository;
	}
	@Override
	public Order saveOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepo.save(order);
	}

	@Override
	public List<Order> getAllOrders(long customerid) {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override
	public Order getOrderById(long customerid) {
		// TODO Auto-generated method stub
		//return orderRepo.findByCustomerId(customerid);
		return null;
	}

	@Override
	public Order updateOrder(Order order, long orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(long orderid) {
		// TODO Auto-generated method stub
		
	}

}
