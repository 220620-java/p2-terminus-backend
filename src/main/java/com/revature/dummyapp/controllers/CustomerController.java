package com.revature.dummyapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
 * 
 */
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(path = "/customer")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * Performs GET method to retrieve all customers available
	 * in the database  
	 * 
	 * @return a list of customers
	 */
	@GetMapping() // change this whatever you want the path to be
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	/**
	 * Performs GET method to retrieve a specific customer
	 * in the database based on id URI path 
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
		Customer customer = customerService.getCustomerById(id);

		if (customer != null) {
			// send a 200 status code with the user object as the response body
			return ResponseEntity.ok(customer);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * Performs POST method to register a new customer
	 * in the database
	 * 
	 * @param customer
	 * @return
	 */
	@PostMapping()
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {

		try {
			customer = customerService.registerCustomer(customer);
		} catch (UsernameTakenException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(customer);

	}

	/**
	 * Performs PUT method to update a specific customer
	 * in the database based on id URI path (requires Auth PUT)
	 * 
	 * @param customer
	 * @param id
	 * @return
	 */
	@PutMapping(path = "/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
		if (customer.getId() == id) {
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

	/**
	 * Performs DELETE method to remove a specific customer
	 * from the database based on id URI path 
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long id) {

		// delete user from DB
		customerService.deleteCustomer(id);

		return new ResponseEntity<>("Customer deleted successfully!.", HttpStatus.OK);
	}

}
