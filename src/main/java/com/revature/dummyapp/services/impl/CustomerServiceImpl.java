package com.revature.dummyapp.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.data.CustomerRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.services.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	

private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer saveCustomer(Customer user) {
		return customerRepository.save(user);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(long id) {
//		Optional<User> user = userRepository.findById(id);
//		if(user.isPresent()) {
//			return user.get();
//		}else {
//			throw new NotFoundException("User", "Id", id);
//		}
		return customerRepository.findById(id).orElseThrow(() -> 
						new NotFoundException("Customer", "customerid", id));
		
	}

	@Override
	public Customer updateCustomer(Customer customer, long id) {
		
		// we need to check whether user with given id is exist in DB or not
		Customer existingUser = customerRepository.findById(id).orElseThrow(
				() -> new NotFoundException("Customer", "customerid", id)); 
		
		if(customer.getUsername() != null) {
			existingUser.setUsername(customer.getUsername());
		}
		if(customer.getPassword() != null) {
			existingUser.setPassword(customer.getPassword());
		}
		if(customer.getFirstname() != null) {
			existingUser.setFirstname(customer.getFirstname());
		}
		if(customer.getEmail() != null) {
			existingUser.setEmail(customer.getEmail());
		}
		
		
		
		
		// save existing user to DB
		customerRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteCustomer(long id) {
		
		// check whether a user exist in a DB or not
		customerRepository.findById(id).orElseThrow(() -> 
								new NotFoundException("Customer", "customeri", id));
		customerRepository.deleteById(id);
	}

}
