package com.revature.dummyapp.services.impl;

import java.util.List;
import java.util.Optional;

import com.revature.dummyapp.data.ProductRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.models.Order;
import com.revature.dummyapp.models.Product;
import com.revature.dummyapp.services.ProductService;

/**
 * 
 * @author Devin
 * @author Tony Wiedman
 *
 */
public class ProductServiceImpl implements ProductService {
	
private ProductRepository productRepo;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepo = productRepository;
	}
	
	@Override
	public List<Product> getAllProducts(long orderid) {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product findByOrderId(long id) {
		Optional<Product> product = productRepo.findByOrderId(id);
		if (product.isPresent()) {
			return product.get();
		} else {
			throw new NotFoundException("Product", "Id", id);
		}
	}


}
