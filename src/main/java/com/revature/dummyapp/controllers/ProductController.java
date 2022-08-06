package com.revature.dummyapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dummyapp.models.Product;
import com.revature.dummyapp.services.ProductService;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/product")
public class ProductController {
	
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping()
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		
		product = productService.saveProduct(product);

		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping 
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id){
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	}
	
	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id){

		// delete user from DB
		productService.deleteProduct(id);

		return new ResponseEntity<String>("Product deleted successfully!.", HttpStatus.OK);
	}
	
	
	
	
}
