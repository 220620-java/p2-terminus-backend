package com.revature.dummyapp.controllers;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.dtos.CustomerDTO;
import com.revature.dummyapp.services.CustomerService;

@WebMvcTest(controllers = CustomerController.class)
class CustomControllerTest {
	
	@MockBean
	private CustomerService customerServ;
	
	@Autowired
	private MockMvc mockMvc;
	
	private ObjectMapper jsonMapper = new ObjectMapper();

	@Test
	void testRegisterCustomer() throws JsonProcessingException, Exception {
		Customer mockCustomer = new Customer();
		Customer mockCustomerWithId = new Customer();
		mockCustomerWithId.setCustomerId(1);
		
		Mockito.when(customerServ.saveCustomer(mockCustomer)).thenReturn(mockCustomerWithId);
		
		mockMvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON)
							.content(jsonMapper.writeValueAsString(mockCustomer)))
							.andExpect(status().isCreated())
							.andExpect(content().json(jsonMapper.writeValueAsString(new CustomerDTO(mockCustomerWithId))));
		
	}

	@Test
	void testGetAllCustomers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCustomerById() throws Exception {
		Customer mockCustomer = new Customer();
		
		Mockito.when(customerServ.getCustomerById(1)).thenReturn(mockCustomer);
		
		mockMvc.perform(get("/customer/1"))
					.andExpect(status().isOk())
					.andExpect(content().json(jsonMapper.writeValueAsString(new CustomerDTO(mockCustomer))));
	
	}

	@Test
	void testUpdateCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteCustomer() {
		fail("Not yet implemented");
	}

}
