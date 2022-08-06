package com.revature.dummyapp.services;

import java.util.List;

import com.revature.dummyapp.models.Product;

/**
 * 
 * @author Devin
 * @author Tony Wiedman
 * @author  Berhanu
 *
 */
public interface ProductService {
	/**
	 * 
	 * @param productid
	 * @return
	 */
	List<Product> getAllProducts(long productid);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

     void deleteProduct(long productid);
}
