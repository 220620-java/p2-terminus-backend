package com.revature.dummyapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dummyapp.models.Order;
import com.revature.dummyapp.models.Product;
import com.revature.dummyapp.services.CustomerService;
import com.revature.dummyapp.services.OrderService;
import com.revature.dummyapp.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	private OrderService orderService;
	private ProductService productService;

	public ProductController(OrderService orderService, ProductService productService) {
		this.orderService = orderService;
		this.productService = productService;
	}
	
	
	@PostMapping(path = "/{id}")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product, @PathVariable long id){
 
		product = productService.saveProduct(product, id);

		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	@GetMapping // change this whatever you want the path to be
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
}
