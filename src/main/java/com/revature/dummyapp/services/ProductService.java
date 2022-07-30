package com.revature.dummyapp.services;

import java.util.List;

import com.revature.dummyapp.models.Product;


public interface ProductService {
	List<Product> getAllProducts(long orderid);
}
