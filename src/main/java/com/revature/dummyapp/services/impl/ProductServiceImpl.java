package com.revature.dummyapp.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.data.ProductRepository;
import com.revature.dummyapp.models.Product;
import com.revature.dummyapp.services.ProductService;


/**
 * 
 * @author Devin
 * @author Tony Wiedman
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepo;
	
	public ProductServiceImpl(ProductRepository productRepo) {
			this.productRepo = productRepo;
	}
	
	@Override
	public List<Product> getAllProducts(long orderid) {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}
	
	
	
	

}
