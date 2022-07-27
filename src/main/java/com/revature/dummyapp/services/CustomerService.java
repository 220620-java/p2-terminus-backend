package com.revature.dummyapp.services;

import java.util.List;

import com.revature.dummyapp.models.Customer;

public interface CustomerService {
	Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerById(long customerid);
	Customer updateCustomer(Customer customer, long customerid);
	void deleteCustomer(long customerid);
}
