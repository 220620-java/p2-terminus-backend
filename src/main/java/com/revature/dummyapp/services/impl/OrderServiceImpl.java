package com.revature.dummyapp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.data.CustomerRepository;
import com.revature.dummyapp.data.OrderRepository;
import com.revature.dummyapp.data.ProductRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.Order;
import com.revature.dummyapp.models.Product;
import com.revature.dummyapp.services.OrderService;

/**
 * 
 * @author Devin
 * @author Tony Wiedman
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	
	private CustomerRepository customerRepo;
	private OrderRepository orderRepo;
	private ProductRepository productRepo;

	public OrderServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository, ProductRepository productRepository) {
		this.customerRepo = customerRepository;
		this.orderRepo = orderRepository;
		this.productRepo = productRepository;
	}
	
	
	
	@Override
	public Customer saveOrder2(Order order, Customer customer) {
		// log.info("Saving new order with id: {}", order.getOrderId());
		
		//get all the users orders
				List<Order> orders = customer.getOrders();
				
				//add current order to the current users orders
				orders.add(order);
				customer.setOrders(orders);
				
			
				
				Product product = productRepo.findById(order.getOrderId()).orElse(null);
				order.setProducts((List<Product>) product);
				orderRepo.save(order);
				
				//List<Product> products = (List<Product>) productRepo.findByOrderId(order.getOrderId()).orElse(null);
				//order.setProducts(products);
				
				//productRepo.saveAll(products);
				
				//Save to customer and order to db
				//orderRepo.save(order);
				customerRepo.save(customer);
				
				return customer;
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order getOrderById(long id) {
		Optional<Order> order = orderRepo.findById(id);
		if (order.isPresent()) {
			return order.get();
		} else {
			throw new NotFoundException("Customer", "Id", id);
		}
	}

	@Override
	public Order updateOrder(Order order) {
			Order existingOrder = orderRepo.findById(order.getOrderId())
					.orElseThrow(() -> new NotFoundException("Customer", "customerid", order.getOrderId()));

			if (order.getOrderDate() != null) {
				existingOrder.setOrderDate(order.getOrderDate());
			}
			if (order.getTotalPrice() != null) {
				existingOrder.setTotalPrice(order.getTotalPrice());
			}
			if (order.getProducts() != null) {
				existingOrder.setProducts(order.getProducts());
			}

			orderRepo.save(existingOrder);
			return existingOrder;
	}

	@Override
	public void deleteOrder(long id) {
		orderRepo.findById(id).orElseThrow(() -> new NotFoundException("Order", "orderid", id));
		orderRepo.deleteById(id);
	}



	@Override
	public Order saveOrder(Order order) {
		return orderRepo.save(order);
	}

}
