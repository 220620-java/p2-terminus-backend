package com.revature.dummyapp.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.dummyapp.DummyMainApplication;
import com.revature.dummyapp.services.CustomerService;

@SpringBootTest(classes=DummyMainApplication.class)
public class AuthControllerTest {
	@MockBean
	private CustomerService customerServ;
	
//	@Test
//	void testAuthController() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testLogIn() {
//		fail("Not yet implemented");
//	}

}
