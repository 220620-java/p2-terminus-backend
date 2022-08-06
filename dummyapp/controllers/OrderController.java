package com.revature.dummyapp.controllers;
<<<<<<< HEAD
=======

>>>>>>> main
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> main
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
<<<<<<< HEAD
import com.revature.dummyapp.models.Order;
import com.revature.dummyapp.services.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	private OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	// build create customer REST API
	@PostMapping()
	public ResponseEntity<Order> saveOrder(@RequestBody Order order){
		return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED);
		
		/*
		try {
			user = userService.saveUser(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(user);
		 */
	}
	
	// build get all users REST API
	@GetMapping(path = "/getallOrders")
	public List<Order> getAllOrder(){
		return orderService.getAllOrders();
	}
	
	// build get user by id REST API
	// http://localhost:8080/user/1
	@GetMapping(path = "/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("orderid") long orderid){
		return new ResponseEntity<Order>(orderService.getOrderById(orderid), HttpStatus.OK);
	}
	
	// build update user REST API
	// http://localhost:8080/users/1
	@PutMapping(path = "/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable("orderid") long orderid,@RequestBody Order Order){
		System.out.println("test");
		return new ResponseEntity<Order>(orderService.updateOrder(Order, orderid), HttpStatus.OK);
	}
	
	// build delete user REST API
	// http://localhost:8080/users/1
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("orderid") long orderid){
		
		// delete user from DB
		orderService.deleteOrder(orderid);
		
		return new ResponseEntity<String>("User deleted successfully!.", HttpStatus.OK);
	}
	

}

    
<<<<<<< HEAD
=======

>>>>>>> cb1e50a3ad9c79434cf4a166b81c06ee64dba329
=======

import com.revature.dummyapp.models.Order;
import com.revature.dummyapp.services.OrderService;

/**
 * 
 * @author Berhanu
 * @author Devin
 *
 */
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
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
>>>>>>> main
