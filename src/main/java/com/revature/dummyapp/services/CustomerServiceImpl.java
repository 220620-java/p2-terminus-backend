package com.revature.dummyapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.data.CustomerRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.Product;


@Service
public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepo;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepo = customerRepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
	//log.info("Saving new customer: {}", customer.getFirstname());
		return customerRepo.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(long id) {
//		Optional<User> user = userRepository.findById(id);
//		if(user.isPresent()) {
//			return user.get();
//		}else {
//			throw new NotFoundException("User", "Id", id);
//		}
		return customerRepo.findById(id).orElseThrow(() -> 
						new NotFoundException("Customer", "customerid", id));
		
	}

	@Override
	public Customer updateCustomer(Customer customer, long id) {
		//log.info("Updating customer: {}", customer.getFirstname());
		
		// we need to check whether user with given id is exist in DB or not
		Customer existingUser = customerRepo.findById(id).orElseThrow(
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
		customerRepo.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteCustomer(long id) {
		//log.info("Deleted customer...")
		
		// check whether a user exist in a DB or not
<<<<<<< HEAD:src/main/java/com/revature/dummyapp/services/CustomerServiceImpl.java
		customerRepo.findById(id).orElseThrow(() -> 
								new NotFoundException("Customer", "customerid", id));
		customerRepo.deleteById(id);
	}

	@Override
	public Product getProduct(long id) {
		// TODO Auto-generated method stub
		return null;
=======
		customerRepository.findById(id).orElseThrow(() -> 
								new NotFoundException("Customer", "customeri", id));
		customerRepository.deleteById(id);
>>>>>>> cb1e50a3ad9c79434cf4a166b81c06ee64dba329:src/main/java/com/revature/dummyapp/services/impl/CustomerServiceImpl.java
	}

}
