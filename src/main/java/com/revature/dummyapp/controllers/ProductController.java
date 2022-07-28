package com.revature.dummyapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dummyapp.models.Product;
import com.revature.dummyapp.services.CustomerService;

/**
 * Handles the HTTP request and reponses of the
 * products that customers can access
 * 
 * @author devin
 *
 */

@RestController
@RequestMapping(path = "/products")
public class ProductController {
	/* Fields */
	private CustomerService customerServ;
	
	
	/* Constructors */
	public ProductController(CustomerService customerServ) {
		this.customerServ = customerServ; 
	}
	
	//@GetMapping
	//public ResponseEntity<Product> viewAllProducts() {
		//List<Product> products = customerServ.viewAllProducts();
		//return ResponseEntity.ok(products);
	//}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = customerServ.getProduct(id);
		
		if(product != null) {
			// Ok sets status to 200
			return ResponseEntity.ok(product);
		} else {
			// not found sets status code to 404
			return ResponseEntity.notFound().build();
		}
	}
	
	//TODO Determine if we need an AdminService or something similar
	
//	@PostMapping
//	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
//		product = adminServ.addProduct(product);
//		return ResponseEntity.status(HttpStatus.CREATED).body(product);
//	}
//	
//	@PutMapping(path = "/{productId}")
//	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("productId") Long id) {
//		if(product.getProductId() == id) {
//			product = adminServ.updateProduct(product);
//			return ResponseEntity.ok(product);
//		} else {
//			return ResponseEntity.status(HttpStatus.CONFLICT).build();
//		}
//	}

}
