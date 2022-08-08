package com.revature.dummyapp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.data.ProductRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.models.Product;
import com.revature.dummyapp.services.ProductService;

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
 * 
 */
@Service
public class ProductServiceImpl implements ProductService {
	private ProductRepository productRepo;
	
	public ProductServiceImpl(ProductRepository productRepo) {
			this.productRepo = productRepo;
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}
	
	@Override
	public Product saveProduct(Product product) {
		product = productRepo.save(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		if (productRepo.findById(product.getProductId()).isPresent()) {
			productRepo.save(product);
		
			Optional<Product> productOpt = productRepo.findById(product.getProductId());
			if (productOpt.isPresent())
				return productOpt.get();
		}
		return null;
	
	}

	@Override
	public void deleteProduct(long id) throws NotFoundException {
		Optional<Product> product = productRepo.findById(id);
        if (product.isPresent()) {
        	productRepo.deleteById(id);
        } else {
            throw new NotFoundException("Product", "Id", id);
        }

	}

	@Override
	public Product getProductById(long id) {
		Optional<Product> product = productRepo.findById(id);
		if (product.isPresent()) {
			return product.get();
		} else {
			throw new NotFoundException("Product", "Id", id);
		}
	}

}
