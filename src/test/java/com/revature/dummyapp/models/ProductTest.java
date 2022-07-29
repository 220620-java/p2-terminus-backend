package com.revature.dummyapp.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductTest {
	
	Product product;
	
	@Test
	void testProductGettersAndSetters() {
		product = new Product();
		product.setProductId(1);
		product.setProductName("test");
		product.setDescription("test description");
		product.setStockQuantity(5);
		product.setPrice(15.00);
		
		Assertions.assertTrue(product.getProductId() == 1);
		Assertions.assertTrue(product.getProductName() == "test");
		Assertions.assertTrue(product.getDescription() == "test description");
		Assertions.assertTrue(product.getStockQuantity() == 5);
		Assertions.assertTrue(product.getPrice() == 15.00);
		
	}
	
	

}
