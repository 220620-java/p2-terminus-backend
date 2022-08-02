package com.revature.dummyapp.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.dummyapp.data.CustomerRepository;
import com.revature.dummyapp.data.OrderRepository;
import com.revature.dummyapp.exceptions.UsernameTakenException;
import com.revature.dummyapp.models.Customer;
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
	void registerUsernametaken() {
		Customer mockCustomer = new Customer();
		mockCustomer.setUsername("test");
		
		Mockito.when(customerRepo.save(mockCustomer)).thenReturn(mockCustomer);
		
		Assertions.assertThrows(UsernameTakenException.class, () -> customerServ.registerCustomer(mockCustomer));
	}
	
	

}
