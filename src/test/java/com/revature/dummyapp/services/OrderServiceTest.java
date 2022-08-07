package com.revature.dummyapp.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.dummyapp.data.OrderRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.models.Order;

@SpringBootTest
class OrderServiceTest {
	@MockBean
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderService orderServ;

	@Test
	void testSaveOrder() {
		Order mockOrder = new Order();
		Order mockOrderWithId = new Order();
		mockOrderWithId.setOrderId(1);
		
		Mockito.when(orderRepo.save(mockOrder)).thenReturn(mockOrderWithId);
		
		Order returnedOrder = orderServ.saveOrder(mockOrder);
		
		Assertions.assertNotNull(returnedOrder);
		
	}

	@Test
	void testGetAllOrders() {
		List<Order> mockOrderList = new ArrayList<>();
		
		Mockito.when(orderRepo.findAll()).thenReturn(mockOrderList);
		
		List<Order> returnedOrders = orderServ.getAllOrders();
		
		Assertions.assertNotNull(returnedOrders);
		
	}
	
	@Test
	void testGetOrderById() {
		Order mockOrder = new Order();
		long id = 1;
		
		Mockito.when(orderRepo.findById(id)).thenReturn(Optional.of(mockOrder));
		
		Assertions.assertEquals(mockOrder, orderServ.getOrderById(id));
	}

	@Test
	void testGetOrderByIdNotFound() {
		Optional<Order> mockOrder = java.util.Optional.empty();

		Mockito.when(orderRepo.findById(1L)).thenReturn(mockOrder);
		
		Assertions.assertThrows(NotFoundException.class, () -> {
			orderServ.getOrderById(1);
		});
	}

	@Test
	void testUpdateOrder() {
		Order mockOrder = new Order();
		long id = 0;
		
		Mockito.when(orderRepo.findById(id)).thenReturn(Optional.of(mockOrder));
		Mockito.when(orderRepo.save(mockOrder)).thenReturn(mockOrder);
		
		Assertions.assertEquals(mockOrder, orderServ.updateOrder(mockOrder));
		
	}

	@Test
	void testDeleteOrder() {
		Order mockOrder = new Order();
		mockOrder.setOrderId(1);
		
		orderRepo.deleteById(mockOrder.getOrderId());
		
		Assertions.assertEquals(Optional.empty(), orderRepo.findById(mockOrder.getOrderId()));
	}
	
}
