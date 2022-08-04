package com.revature.dummyapp.services;

import java.util.List;

import com.revature.dummyapp.models.Product;

/**
 * 
 * @author Devin
 * @author Tony Wiedman
 *
 */
public interface ProductService {
	/**
	 * 
	 * @param orderid
	 * @return
	 */
	List<Product> getAllProducts();

	Product saveProduct(Product product);
}
