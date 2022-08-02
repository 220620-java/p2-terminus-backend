package com.revature.dummyapp.services;

import java.util.List;

import com.revature.dummyapp.exceptions.UsernameTakenException;
import com.revature.dummyapp.models.Customer;


/**
 * 
 * @author Tony Wiedman
 *
 */
public interface CustomerService {
	/**
	 * 
	 * @param customer
	 * @return
	 * @throws UsernameTakenException
	 */
	Customer registerCustomer(Customer customer) throws UsernameTakenException;
	
	/**
	 * 
	 * @return
	 */
	List<Customer> getAllCustomers();
	
	/**
	 * 
	 * @param customerid
	 * @return
	 */
	Customer getCustomerById(long customerid);
	
	/**
	 * 
	 * @param customer
	 * @return
	 */
	Customer updateCustomer(Customer customer);
	
	/**
	 * 
	 * @param customerid
	 */
	void deleteCustomer(long customerid);
	//Order getOrder(long id);
}
