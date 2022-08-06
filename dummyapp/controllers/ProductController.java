package com.revature.dummyapp.controllers;

import java.util.List;
import java.util.Map;
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
 * 
 * @author Berhanu
 * @author Devin
 *
 */
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/product")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@CrossOrigin("http://terminus-front.s3-website-us-east-1.amazonaws.com")
	@PostMapping()
	public ResponseEntity<Product> saveOrder(@RequestBody Product product, @RequestBody Map<String, String> productId){
		
		String id = productId.get("productId");
		
		product.setProductId(id);
		
		product = productService.saveProduct(product);

		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	@CrossOrigin("http://terminus-front.s3-website-us-east-1.amazonaws.com")
	@GetMapping // change this whatever you want the path to be
	public List<Product> getAllProducts(){
		return productService.getAllProducts(0);
	}

	// http://localhost:8080/order/1
	@CrossOrigin("http://terminus-front.s3-website-us-east-1.amazonaws.com")
	@GetMapping(path = "/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id){
		return new ResponseEntity<Product>(HttpStatus.OK);
	}

	// http://localhost:8080/order/1
	@CrossOrigin("http://terminus-front.s3-website-us-east-1.amazonaws.com")
	@PutMapping(path = "/{id}")
	public ResponseEntity<Product> updateOrder(@RequestBody Product product, @PathVariable long id){

		if (product.getProductById == id) {
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

	// http://localhost:8080/order/1
	@CrossOrigin("http://terminus-front.s3-website-us-east-1.amazonaws.com")
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id){

		// delete product from DB
		productService.deleteProduct(id);

		return new ResponseEntity<String>("Product deleted successfully!.", HttpStatus.OK);
	}


}


