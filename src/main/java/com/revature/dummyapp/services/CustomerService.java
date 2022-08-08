package com.revature.dummyapp.services;

import java.util.List;

import com.revature.dummyapp.exceptions.UsernameTakenException;
import com.revature.dummyapp.models.Customer;

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
 * 
 */
public interface CustomerService {
	/**
	 * Registers a new customer in the database
	 * 
	 * @param customer
	 * @return returns Customer that was registered
	 * @throws UsernameTakenException
	 */
	Customer registerCustomer(Customer customer) throws UsernameTakenException;
	
	/**
	 * Retrieve a list of all customers in the database
	 * 
	 * @return list of Customers
	 */
	List<Customer> getAllCustomers();
	
	/**
	 * Retrieves a specific customer from the database
	 * based on the id
	 * 
	 * @param customerid
	 * @return
	 */
	Customer getCustomerById(long customerid);
	
	/**
	 * Updates the customers information in the database
	 * 
	 * @param customer
	 * @return
	 */
	Customer updateCustomer(Customer customer);
	
	/**
	 * Removes a customer from the database based on id
	 * 
	 * @param customerid
	 */
	void deleteCustomer(long customerid);
	
	/**
	 * Allows a customer with an account to log in
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	Customer logIn(String username, String password);
}
