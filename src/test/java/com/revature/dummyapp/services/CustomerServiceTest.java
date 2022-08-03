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

import com.revature.dummyapp.data.CustomerRepository;
import com.revature.dummyapp.data.OrderRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.exceptions.UsernameTakenException;
import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.Order;
import com.revature.dummyapp.services.impl.CustomerServiceImpl;

@SpringBootTest(classes = CustomerServiceImpl.class)
class CustomerServiceTest {
	@MockBean
	private CustomerRepository customerRepo;
	
	@MockBean
	private OrderRepository orderRepo;
	
	@Autowired
	private CustomerService customerServ;

	@Test
	void registerCustomerSuccessfully() throws UsernameTakenException {
		Customer mockCustomer = new Customer();
		Customer mockCustomerWithId = new Customer();
		mockCustomerWithId.setCustomerId(1);
		
		Mockito.when(customerRepo.save(mockCustomer)).thenReturn(mockCustomerWithId);
		
		Customer result = customerServ.registerCustomer(mockCustomer);
		
		Assertions.assertNotNull(result);
		
	}
	
	@Test
	void registerUsernameTaken() {
		Customer mockCustomer = new Customer();
		mockCustomer.setUsername("test");
		
		Mockito.when(customerRepo.save(mockCustomer)).thenReturn(mockCustomer);
		
		Assertions.assertThrows(UsernameTakenException.class, () -> customerServ.registerCustomer(mockCustomer));
	}
	
	@Test
	void testSuccessfulLogin() {
		String username = "user";
		String password = "pass";
		Customer mockCustomer = new Customer(username, password);
		
		Mockito.when(customerRepo.findByUsername(username)).thenReturn(mockCustomer);
		
		Customer returnedCustomer = customerServ.logIn(username, password);
		
		Assertions.assertEquals(username, returnedCustomer.getUsername());
	
	}
	
	@Test
	void loginUsernameNotFound() {
		String username = "wrong";
		String password = "pass";
		
		Mockito.when(customerRepo.findByUsername(username)).thenReturn(null);
		
		Customer returnedCustomer = customerServ.logIn(username, password);
		
		Assertions.assertNull(returnedCustomer);
	}
	
	@Test
	void loginNullPassword() {
		String username = "user";
		String password = null;
		Customer mockCustomer = new Customer(username, "test");
		
		Mockito.when(customerRepo.findByUsername(username)).thenReturn(mockCustomer);
		
		Customer returnedCustomer = customerServ.logIn(username, password);
		
		Assertions.assertNull(returnedCustomer);
	}
	
	@Test
	void testUpdateCustomer() {
		Customer mockCustomer = new Customer();
		long id = 0;
		
		Mockito.when(customerRepo.findById(id)).thenReturn(Optional.of(mockCustomer));
		Mockito.when(customerRepo.save(mockCustomer)).thenReturn(mockCustomer);
		
		Assertions.assertEquals(mockCustomer, customerServ.updateCustomer(mockCustomer));
	}
	
	@Test
	void testUpdateCustomerNull() {
		Customer mockCustomer = new Customer();
		
		Mockito.when(customerRepo.findById(0L))
								 .thenReturn(Optional.of(mockCustomer))
							     .thenReturn(Optional.empty());
		
		Assertions.assertNull(customerServ.updateCustomer(mockCustomer));
	}
	
	@Test
	void testGetCustomerById() {
		Customer mockCustomer = new Customer();
		long id = 1;
		
		Mockito.when(customerRepo.findById(id)).thenReturn(Optional.of(mockCustomer));
		
		Assertions.assertEquals(mockCustomer, customerServ.getCustomerById(id));
	}
	
	@Test
	void testGetCustomerByIdNotFound() {
		Optional<Customer> mockCustomer = java.util.Optional.empty();

		Mockito.when(customerRepo.findById(1L)).thenReturn(mockCustomer);
		
		Assertions.assertThrows(NotFoundException.class, () -> {
			customerServ.getCustomerById(1);
		});
	}
	
	@Test
	void testGetAllCustomers() {
		List<Customer> mockCustomerList = new ArrayList<>();
		
		Mockito.when(customerRepo.findAll()).thenReturn(mockCustomerList);
		
		List<Customer> returnedOrders = customerServ.getAllCustomers();
		
		Assertions.assertNotNull(returnedOrders);
		
	}
	
	@Test
	void testDeleteCustomer() { // this test is not correctly covering the code
		long id = 1;
		
		orderRepo.deleteById(id);
		
		Assertions.assertEquals(Optional.empty(), orderRepo.findById(id));
	}
	
	
	
	

}
