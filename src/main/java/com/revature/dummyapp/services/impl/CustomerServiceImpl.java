package com.revature.dummyapp.services.impl;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.data.CustomerRepository;
import com.revature.dummyapp.data.OrderRepository;
import com.revature.dummyapp.data.ProductRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.exceptions.UsernameTakenException;
import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.Order;
import com.revature.dummyapp.models.Product;
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
	private ProductRepository productRepo;

	public CustomerServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository, ProductRepository productRepository) {
		this.customerRepo = customerRepository;
		this.orderRepo = orderRepository;
		this.productRepo = productRepository;
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
	
	@Override
	public Customer completeOrder(Order order, Customer customer) {
		if (customer == null || order == null) {
			return null;
		}

		//get all the users orders
		List<Order> orders = customer.getOrders();
		
		//add current order to the current users orders
		orders.add(order);
		customer.setOrders(orders);
		
		
		//List<Product> products = order.getProducts();
		//products.add(productRepo.findById(order.getOrderId()).orElse(null));
		
		List<Product> products = (List<Product>) productRepo.findById(order.getOrderId()).orElse(null);
		order.setProducts(products);
		
		
		//Save to customer and order to db
		orderRepo.save(order);
		customerRepo.save(customer);
		
		
		
		
		return customer;
	}
	
}
