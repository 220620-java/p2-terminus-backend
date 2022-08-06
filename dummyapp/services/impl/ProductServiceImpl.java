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
	
	/* Experimenting with WebClient in order to access Fake Store API */

//	private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(3);
//	private final WebClient localApiClient;
//	
//	public ProductServiceImpl(WebClient localApiClient) {
//		this.localApiClient = localApiClient;
//	}
//	
//	public Product getProduct(long id) {
//		return localApiClient.get()
//					         .uri("/products/" + id)
//					         .retrieve()
//					         .bodyToMono(Product.class)
//					         .block(REQUEST_TIMEOUT);
//	}
//	
//	public ProductServiceImpl(WebClient.Builder webClientBuilder) {
//		this.localApiClient = webClientBuilder.baseUrl("https://fakestoreapi.com").build();
//	}
//	
//	public Mono<Product> getProductByName(String name) {
//		return this.localApiClient.get().uri("/{name}/products", name).retrieve().bodyToMono(Product.class);
//	}
	 
	
	@Override
	public List<Product> getAllProducts(long orderid) {
		 
		return productRepo.findAll();
	}
	
	@Override
	public Product saveProduct(Product product) {
		// log.info("Saving new order with id: {}", order.getOrderId());
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Product existingProduct = productRepo.findById(product.getId())
					.orElseThrow(() -> new NotFoundException("Product", "productid",product.getId()));

			if (existingProduct != null) {
				existingProduct.setId(product.getId());
			}
			if (product.getOrderId() != null) {
				existingProduct.setOrderId(product.getOrderId());
			}
		 
			 productRepo.save(existingProduct);
			 return existingProduct;
	}

 
	@Override
	public void deleteProduct(long id) {

		 if (productRepo.findById(id) != null){
			productRepo.deleteById(id);
		 }else throw new NotFoundException("Product", "Id", id);
		
		}
			 

}
