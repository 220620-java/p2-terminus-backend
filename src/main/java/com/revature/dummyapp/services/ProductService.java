package com.revature.dummyapp.services;

import java.util.List;

import com.revature.dummyapp.models.Order;
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
	
	/**
	 * 
	 * @param orderid
	 * @return
	 */
	Product getProductById(long id);
	
	/**
	 * 
	 * @param product
	 * @return
	 */
	Product saveProduct(Product product);
	
	/**
	 * 
	 * @param orderid
	 */
	void deleteProduct(long orderid);
	
}
