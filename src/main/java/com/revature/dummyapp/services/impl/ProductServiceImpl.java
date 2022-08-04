package com.revature.dummyapp.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.data.ProductRepository;
import com.revature.dummyapp.models.Order;
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
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}
	
	@Override
	public Product saveProduct(Product product, long orderid) {
		// log.info("Saving new order with id: {}", order.getOrderId());
		product.setOrderId(orderid);
		return productRepo.save(product);
	}
	
	

}
