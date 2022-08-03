package com.revature.dummyapp.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.dtos.CustomerDTO;
import com.revature.dummyapp.services.CustomerService;
import com.revature.dummyapp.services.TokenService;

/**
 * @author Tony Wiedman
 * 
 */

@RestController
@RequestMapping(path="/auth")
public class AuthController {
	
	private CustomerService userServ;
	private TokenService tokenServ;

	
	public AuthController(CustomerService userServ, TokenService tokenServ) {
		this.userServ = userServ;
		this.tokenServ = tokenServ;
	}

	@PostMapping
	public ResponseEntity<CustomerDTO> logIn(@RequestBody Map<String, String> credentials) {
		String username = credentials.get("username");
		String password = credentials.get("password");
		
		Customer customer = userServ.logIn(username, password);
		
		if (customer!=null) {
			CustomerDTO customerDto = new CustomerDTO(customer);
			String jws = tokenServ.createToken(customer);
			return ResponseEntity.status(200).header("Auth", jws).body(customerDto);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}


}
