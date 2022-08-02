package com.revature.dummyapp.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dummyapp.models.Order;
import com.revature.dummyapp.models.dtos.OrderDTO;
import com.revature.dummyapp.services.OrderService;

@WebMvcTest(controllers = OrderController.class)
class OrderControllerTest {
	
	@MockBean
	private OrderService orderServ;
		
	@Autowired
	private MockMvc mockMvc;
		
	private ObjectMapper jsonMapper = new ObjectMapper();

	@Test
	void testSaveOrder() throws JsonProcessingException, Exception {
		Order mockOrder = new Order();
		Order mockOrderWithId = new Order();
		mockOrderWithId.setOrderId(1);
		
		Mockito.when(orderServ.saveOrder(mockOrder)).thenReturn(mockOrderWithId);
		
		mockMvc.perform(post("/order").contentType(MediaType.APPLICATION_JSON)
				.content(jsonMapper.writeValueAsString(mockOrder)))
				.andExpect(status().isCreated())
				.andExpect(content().json(jsonMapper.writeValueAsString(new OrderDTO(mockOrderWithId))));
		
	}

	@Test
	void testGetAllOrders() throws JsonProcessingException, Exception {
		List<Order> mockOrders = new ArrayList<>();
		
		Mockito.when(orderServ.getAllOrders()).thenReturn(mockOrders);
		
		mockMvc.perform(get("/order")).andExpect(status().isOk())
										 .andExpect(content().json(jsonMapper.writeValueAsString(mockOrders)));
		
	}

	@Test
	void testGetOrderById() throws JsonProcessingException, Exception {
		Order mockOrder = new Order();
		
		Mockito.when(orderServ.getOrderById(1)).thenReturn(mockOrder);
		
		mockMvc.perform(get("/order/1"))
					.andExpect(status().isOk())
					.andExpect(content().json(jsonMapper.writeValueAsString(new OrderDTO(mockOrder))));
		
	}

	@Test
	void testUpdateOrder() throws JsonProcessingException, Exception {
		Order mockOrder = new Order();
		mockOrder.setOrderId(1);
		
		Mockito.when(orderServ.updateOrder(mockOrder)).thenReturn(mockOrder);
		
		mockMvc.perform(put("/order/1").contentType(MediaType.APPLICATION_JSON)
									.content(jsonMapper.writeValueAsString(mockOrder)))
									.andExpect(status().isOk())
									.andExpect(content().json(jsonMapper.writeValueAsString(new OrderDTO(mockOrder))));
		
	}

	@Test
	void testDeleteOrder() throws Exception {
	
		ResultActions response = mockMvc.perform(delete("/order/1"));
		
		response.andExpect(status().isOk()).andDo(print());
	}

}
