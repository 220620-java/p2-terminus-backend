package com.revature.dummyapp.controllers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.Map;

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
import com.revature.dummyapp.services.TokenService;

@WebMvcTest(controllers = AuthController.class)
public class AuthControllerTest {
	@MockBean
	private CustomerService customerServ;
	
	@MockBean
	private TokenService tokenServ;
	
	@Autowired
	private MockMvc mockMvc;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Test
    void testLoginAuth() throws JsonProcessingException, Exception {
		Map<String, String> credentials = new HashMap<>();
		credentials.put("username", "user");
		credentials.put("password", "pass");
		
		String username = credentials.get("username");
        String password = credentials.get("password");
		
		Customer mockCustomer = new Customer(username, password);
		
		CustomerDTO customerMockDto = new CustomerDTO(mockCustomer);
		customerMockDto.setToken("token");
		Mockito.when(customerServ.logIn("user", "pass")).thenReturn(mockCustomer);
		Mockito.when(tokenServ.createToken(mockCustomer)).thenReturn("token");
		
		mockMvc.perform(post("/auth").contentType(MediaType.APPLICATION_JSON)
									 .content(objectMapper.writeValueAsString(credentials)))
		                             .andExpect(status().isOk())
		                             .andExpect(content().json(objectMapper.writeValueAsString(customerMockDto)));
		
	}
	
	@Test
    void loginNullCustomerAuth () throws Exception {
		Map<String, String> credentials = new HashMap<>();
		credentials.put("username", "user");
		credentials.put("password", "pass");
        
		Mockito.when(customerServ.logIn("user", "pass")).thenReturn(null);
        
        mockMvc.perform(post("/auth").contentType(MediaType.APPLICATION_JSON)
        							 .content(objectMapper.writeValueAsString(credentials)))
        							 .andExpect(status().isUnauthorized());
    }

}
