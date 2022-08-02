package com.revature.dummyapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * 
 * @author Berhanu
 * @author Devin
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@PostMapping()
	public ResponseEntity<Order> saveOrder(@RequestBody Order order){
 
		order = orderService.saveOrder(order);

		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}

	@GetMapping // change this whatever you want the path to be
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}

	// http://localhost:8080/order/1
	@GetMapping(path = "/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable long id){
		return new ResponseEntity<Order>(orderService.getOrderById(id), HttpStatus.OK);
	}

	// http://localhost:8080/order/1
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

	// http://localhost:8080/order/1
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable long id){

		// delete user from DB
		orderService.deleteOrder(id);

		return new ResponseEntity<String>("Order deleted successfully!.", HttpStatus.OK);
	}


}
