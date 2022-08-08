package com.revature.dummyapp.services;

import java.util.List;

import com.revature.dummyapp.models.Product;

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
 * 
 */
public interface ProductService {
	/**
	 * Retrieves a list of all products in the database
	 * 
	 * @param orderid
	 * @return
	 */
	List<Product> getAllProducts();
	
	/**
	 * Retrieves a product from the database
	 * based on product id
	 * 
	 * @param id
	 * @return
	 */
	Product getProductById(long id);
	
	/**
	 * Saves a new product to the database
	 * 
	 * @param product
	 * @return returns product that was successfully saved
	 */
	Product saveProduct(Product product);

	/**
	 * 
	 * @param product
	 * @return
	 */
	Product updateProduct(Product product);

	/**
	 * Removes specific product from the database
	 * based on id
	 * 
	 * @param id
	 */
	void deleteProduct(long id);
}
