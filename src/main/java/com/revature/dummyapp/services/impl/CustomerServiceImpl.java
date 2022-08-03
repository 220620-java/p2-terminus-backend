package com.revature.dummyapp.services.impl;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.data.CustomerRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.exceptions.UsernameTakenException;
import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.services.CustomerService;

/**
 * 
 * @author Tony Wiedman
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepo;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepo = customerRepository;
	}

	@Override
	public Customer registerCustomer(Customer customer) throws UsernameTakenException {
		// log.info("Saving new customer: {}", customer.getFirstname());
		customer.setCustomerId(0);
		customer = customerRepo.save(customer);
		
		if(customer.getCustomerId() == 0) {
			throw new UsernameTakenException();
		}
		
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(long id) {
		Optional<Customer> user = customerRepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new NotFoundException("Customer", "Id", id);
		}
		// return customerRepo.findById(id).orElseThrow(() ->
		// new NotFoundException("Customer", "customerid", id));

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// log.info("Updating customer: {}", customer.getFirstname());

		// we need to check whether user with given id is exist in DB or not
//		Customer existingUser = customerRepo.findById(customer.getCustomerId())
//				.orElseThrow(() -> new NotFoundException("Customer", "customerid", customer.getCustomerId()));
//
//		if (customer.getUsername() != null) {
//			existingUser.setUsername(customer.getUsername());
//		}
//		if (customer.getPassword() != null) {
//			existingUser.setPassword(customer.getPassword());
//		}
//		if (customer.getFirstname() != null) {
//			existingUser.setFirstname(customer.getFirstname());
//		}
//		if (customer.getEmail() != null) {
//			existingUser.setEmail(customer.getEmail());
//		}
//
//		// save existing user to DB
//		customerRepo.save(existingUser);
//		return existingUser;
		
		if (customerRepo.findById(customer.getId()).isPresent()) {
				customerRepo.save(customer);
			
			Optional<Customer> customerOpt = customerRepo.findById(customer.getId());
			if (customerOpt.isPresent())
				return customerOpt.get();
		}
		return null;

	}

	@Override
	public void deleteCustomer(long id) {
		// log.info("Deleted customer...")

		// check whether a user exist in a DB or not
		customerRepo.findById(id).orElseThrow(() -> new NotFoundException("Customer", "customerid", id));
		customerRepo.deleteById(id);
	}

	@Override
	public Customer logIn(String username, String password) {
		Customer customer = customerRepo.findByUsername(username);
		if (customer != null && (password!=null && password.equals(customer.getPassword()))) {
			return customer;
		} else {
			return null;
		}
	}
}
