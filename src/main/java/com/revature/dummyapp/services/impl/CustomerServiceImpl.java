package com.revature.dummyapp.services.impl;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.data.CustomerRepository;
import com.revature.dummyapp.data.OrderRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
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
	private OrderRepository orderRepo;

	public CustomerServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository) {
		super();
		this.customerRepo = customerRepository;
		this.orderRepo = orderRepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// log.info("Saving new customer: {}", customer.getFirstname());
		return customerRepo.save(customer);
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
			throw new NotFoundException("User", "Id", id);
		}
		// return customerRepo.findById(id).orElseThrow(() ->
		// new NotFoundException("Customer", "customerid", id));

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// log.info("Updating customer: {}", customer.getFirstname());

		// we need to check whether user with given id is exist in DB or not
		Customer existingUser = customerRepo.findById(customer.getCustomerId())
				.orElseThrow(() -> new NotFoundException("Customer", "customerid", customer.getCustomerId()));

		if (customer.getUsername() != null) {
			existingUser.setUsername(customer.getUsername());
		}
		if (customer.getPassword() != null) {
			existingUser.setPassword(customer.getPassword());
		}
		if (customer.getFirstname() != null) {
			existingUser.setFirstname(customer.getFirstname());
		}
		if (customer.getEmail() != null) {
			existingUser.setEmail(customer.getEmail());
		}

		// save existing user to DB
		customerRepo.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteCustomer(long id) {
		// log.info("Deleted customer...")

		// check whether a user exist in a DB or not
		customerRepo.findById(id).orElseThrow(() -> new NotFoundException("Customer", "customerid", id));
		customerRepo.deleteById(id);
	}

	// @Override
	// public Order getOrder(long id) {
	// Optional<Order> orderOpt =
	// Optional.ofNullable(orderRepo.findByCustomerId(id));
	//
	// if (orderOpt.isPresent()) {
	// return orderOpt.get();
	// } else return null;
	//
	// }

}
