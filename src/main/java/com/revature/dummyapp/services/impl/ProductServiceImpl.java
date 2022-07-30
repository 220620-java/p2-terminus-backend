package com.revature.dummyapp.services.impl;

import java.util.List;

import com.revature.dummyapp.data.ProductRepository;
import com.revature.dummyapp.models.Product;
import com.revature.dummyapp.services.ProductService;

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

}
