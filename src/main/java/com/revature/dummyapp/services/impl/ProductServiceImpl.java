package com.revature.dummyapp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.data.ProductRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
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
	public Product saveProduct(Product product) {
		
		product = productRepo.save(product);
		
		return product;
		
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		productRepo.findById(id).orElseThrow(() -> new NotFoundException("Product", "id", id));
		productRepo.deleteById(id);
	}


	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}


	@Override
	public Product getProductById(long id) {
		Optional<Product> product = productRepo.findById(id);
		if (product.isPresent()) {
			return product.get();
		} else {
			throw new NotFoundException("Customer", "Id", id);
		}
	}


	
	
	
	

}
