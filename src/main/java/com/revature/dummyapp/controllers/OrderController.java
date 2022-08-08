package com.revature.dummyapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dummyapp.models.Order;
import com.revature.dummyapp.services.OrderService;

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * 
 */
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(path = "/order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	/**
	 * Performs POST method to save an order in the database
	 * 
	 * @param order
	 * @return
	 */
	@PostMapping()
	public ResponseEntity<Order> saveOrder(@RequestBody Order order){
		
		order = orderService.saveOrder(order);

		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}
	
	/**
	 * Performs GET method to retrieve all orders available
	 * in the database
	 * 
	 * @return
	 */
	@GetMapping
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	/**
	 * Performs GET method to retrieve a specific order
	 * from the database based on id URI path 
	 * 
	 * http://localhost:8080/order/1
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable long id){
		return new ResponseEntity<Order>(orderService.getOrderById(id), HttpStatus.OK);
	}

	/**
	 * Performs PUT method to update a specific order
	 * in the database based on id URI path
	 * 
	 * @param order
	 * @param id
	 * @return
	 */
	@PutMapping(path = "/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable long id){

		if (order.getOrderId() == id) {
			order = orderService.updateOrder(order);
			if (order != null) {
				return ResponseEntity.ok(order);
			} else {
				return ResponseEntity.badRequest().build();
			}
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	/**
	 * Performs DELETE method to remove a specific order
	 * from the database based on id URI path 
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable long id){
		orderService.deleteOrder(id);

		return new ResponseEntity<String>("Order deleted successfully!.", HttpStatus.OK);
	}


}
