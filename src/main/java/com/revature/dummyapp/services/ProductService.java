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
	
	Product getProductById(long id);

	Product saveProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(long id);
}
