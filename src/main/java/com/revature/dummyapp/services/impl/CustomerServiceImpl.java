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
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
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
		customer.setId(0);
		customer = customerRepo.save(customer);
		
		if(customer.getId() == 0) {
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

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		if (customerRepo.findById(customer.getId()).isPresent()) {
				customerRepo.save(customer);
			
			Optional<Customer> customerOpt = customerRepo.findById(customer.getId());
			if (customerOpt.isPresent())
				return customerOpt.get();
		}
		return null;

	}

	@Override
	public void deleteCustomer(long id) throws NotFoundException {
		Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
        	customerRepo.deleteById(id);
        } else {
            throw new NotFoundException("Customer", "Id", id);
        }
		
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
