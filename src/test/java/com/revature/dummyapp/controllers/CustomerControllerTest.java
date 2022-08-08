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
import com.revature.dummyapp.exceptions.UsernameTakenException;
import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.dtos.CustomerDTO;
import com.revature.dummyapp.services.CustomerService;

@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerTest {
	
	@MockBean
	private CustomerService customerServ;
	
	@Autowired
	private MockMvc mockMvc;
	
	private ObjectMapper jsonMapper = new ObjectMapper();

	@Test
	void testRegisterCustomer() throws JsonProcessingException, Exception {
		Customer mockCustomer = new Customer();
		Customer mockCustomerWithId = new Customer();
		mockCustomerWithId.setId(1);
		
		Mockito.when(customerServ.registerCustomer(mockCustomer)).thenReturn(mockCustomerWithId);
		
		mockMvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON)
							.content(jsonMapper.writeValueAsString(mockCustomer)))
							.andExpect(status().isCreated())
							.andExpect(content().json(jsonMapper.writeValueAsString(new CustomerDTO(mockCustomerWithId))));
		
	}
	
	@Test 
	void testCustomerAlreadyExists() throws JsonProcessingException, Exception {
		Customer mockCustomer = new Customer();
		
		Mockito.when(customerServ.registerCustomer(mockCustomer)).thenThrow(UsernameTakenException.class);
		
		mockMvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON)
				                         .content(jsonMapper.writeValueAsString(mockCustomer)))
		                                 .andExpect(status().isConflict());
	}

	@Test
	void testGetAllCustomers() throws JsonProcessingException, Exception {
		List<Customer> mockCustomers = new ArrayList<>();
		
		Mockito.when(customerServ.getAllCustomers()).thenReturn(mockCustomers);
		
		mockMvc.perform(get("/customer")).andExpect(status().isOk())
										 .andExpect(content().json(jsonMapper.writeValueAsString(mockCustomers)));
		
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
	void testGetCustomerByIdNull() throws Exception {
		
		Mockito.when(customerServ.getCustomerById(1)).thenReturn(null);
		
		mockMvc.perform(get("/customer/1"))
					.andExpect(status().isNotFound());
	
	}

	@Test
	void testUpdateCustomer() throws JsonProcessingException, Exception {
		Customer mockCustomer = new Customer();
		mockCustomer.setId(1);
		
		Mockito.when(customerServ.updateCustomer(mockCustomer)).thenReturn(mockCustomer);
		
		mockMvc.perform(put("/customer/1").contentType(MediaType.APPLICATION_JSON)
									.content(jsonMapper.writeValueAsString(mockCustomer)))
									.andExpect(status().isOk())
									.andExpect(content().json(jsonMapper.writeValueAsString(new CustomerDTO(mockCustomer))));
	}
	
	@Test
	void testUpdateNullCustomer() throws JsonProcessingException, Exception {
		Customer mockCustomer = new Customer();
		mockCustomer.setId(1);
		
		Mockito.when(customerServ.updateCustomer(mockCustomer)).thenReturn(null);
		
		mockMvc.perform(put("/customer/1").contentType(MediaType.APPLICATION_JSON)
				                        .content(jsonMapper.writeValueAsString(mockCustomer)))
		                                .andExpect(status().isBadRequest());
	}
	
	@Test
    void updateCustomerConflict() throws JsonProcessingException, Exception {
		Customer mockCustomer = new Customer();
		mockCustomer.setId(1);
		
		mockMvc.perform(put("/customer/2")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonMapper.writeValueAsString(mockCustomer)))
			.andExpect(status().isConflict());
	}
	
	@Test
	void testDeleteCustomer() throws Exception {

		ResultActions response = mockMvc.perform(delete("/customer/1"));
		
		response.andExpect(status().isOk()).andDo(print());
		
	}

}
