package com.revature.dummyapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	// build create customer REST API
	@PostMapping()
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
		
		/*
		try {
			user = userService.saveUser(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(user);
		 */
	}
	
	// build get all users REST API
	@GetMapping
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	// build get user by id REST API
	// http://localhost:8080/user/1
	@GetMapping(path = "/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerid") long customerid){
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerid), HttpStatus.OK);
	}
	
	// build update user REST API
	// http://localhost:8080/users/1
	@PutMapping(path = "/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerid") long customerid,@RequestBody Customer Customer){
		System.out.println("test");
		return new ResponseEntity<Customer>(customerService.updateCustomer(Customer, customerid), HttpStatus.OK);
	}
	
	// build delete user REST API
	// http://localhost:8080/users/1
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
		
		// delete user from DB
		customerService.deleteCustomer(id);
		
		return new ResponseEntity<String>("User deleted successfully!.", HttpStatus.OK);
	}
	

}
