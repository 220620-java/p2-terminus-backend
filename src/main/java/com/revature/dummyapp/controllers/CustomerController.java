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

import com.revature.dummyapp.exceptions.UsernameTakenException;
import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.services.CustomerService;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	// http://localhost:8080/customer/getAllCustomers
	@GetMapping() // change this whatever you want the path to be
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	// http://localhost:8080/customer/1
	@GetMapping(path = "/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
	}

	// http://localhost:8080/customer
	@PostMapping()
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
		// return new ResponseEntity<Customer>(customerService.saveCustomer(customer),
		// HttpStatus.CREATED);
		// ERROR: JSON parse error: Cannot deserialize value of type
		// `com.revature.dummyapp.models.Customer`

		try {
			customer = customerService.saveCustomer(customer);
		} catch (UsernameTakenException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(customer);

	}

	// http://localhost:8080/customer/1
	@PutMapping(path = "/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
		// System.out.println("test");
		// return new ResponseEntity<Customer>(customerService.updateCustomer(customer),
		// HttpStatus.OK);

		if (customer.getCustomerId() == id) {
			customer = customerService.updateCustomer(customer);
			if (customer != null) {
				return ResponseEntity.ok(customer);
			} else {
				return ResponseEntity.badRequest().build();
			}
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

	}

	// http://localhost:8080/customer/1
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long id) {

		// delete user from DB
		customerService.deleteCustomer(id);

		return new ResponseEntity<String>("Customer deleted successfully!.", HttpStatus.OK);
	}

}
