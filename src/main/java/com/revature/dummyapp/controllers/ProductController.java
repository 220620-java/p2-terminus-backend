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

import com.revature.dummyapp.models.Product;
import com.revature.dummyapp.services.ProductService;

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
 * 
 */
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping(path = "/product")
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	/**
	 * Performs POST method to save a product in the database
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
	 * Performs GET method to retrieve all products available
	 * in the database
	 * 
	 * @return
	 */
	@GetMapping
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	/**
	 * Performs GET method to retrieve a specific product
	 * from the database based on id URI path 
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id){
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	}
	
	/**
	 * Performs PUT method to update a specific product
	 * in the database based on id URI path
	 * 
	 * @param product
	 * @param id
	 * @return
	 */
	@PutMapping(path = "/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable long id){

		if (product.getProductId() == id) {
			product = productService.updateProduct(product);
			if (product != null) {
				return ResponseEntity.ok(product);
			} else {
				return ResponseEntity.badRequest().build();
			}
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	/**
	 * Performs DELETE method to remove a specific product
	 * from the database based on id URI path 
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id){
		productService.deleteProduct(id);

		return new ResponseEntity<String>("Product deleted successfully!.", HttpStatus.OK);
	}

}

