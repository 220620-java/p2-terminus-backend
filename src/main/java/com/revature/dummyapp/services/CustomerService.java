package com.revature.dummyapp.services;

import java.util.List;

import com.revature.dummyapp.exceptions.UsernameTakenException;
import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.Product;

public interface CustomerService {
	Customer saveCustomer(Customer customer) throws UsernameTakenException;
	List<Customer> getAllCustomers();
	Customer getCustomerById(long customerid);
	Customer updateCustomer(Customer customer);
	void deleteCustomer(long customerid);
	Product getProduct(long id);
}
