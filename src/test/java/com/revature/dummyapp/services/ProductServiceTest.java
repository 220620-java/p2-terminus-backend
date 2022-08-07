package com.revature.dummyapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.dummyapp.data.ProductRepository;
import com.revature.dummyapp.exceptions.NotFoundException;
import com.revature.dummyapp.models.Product;

@SpringBootTest
public class ProductServiceTest {
	@MockBean
	private ProductRepository productRepo;
	
	@Autowired
	private ProductService productServ;

	@Test
	void testSaveProduct() {
		Product mockProduct = new Product();
		Product mockProductWithId = new Product();
		mockProductWithId.setProductId(1);
		
		Mockito.when(productRepo.save(mockProduct)).thenReturn(mockProductWithId);
		
		Product returnedProduct = productServ.saveProduct(mockProduct);
		
		Assertions.assertNotNull(returnedProduct);
	}
	
	@Test
	void testGetAllProducts() {
		List<Product> mockProductList = new ArrayList<>();
		
		Mockito.when(productRepo.findAll()).thenReturn(mockProductList);
		
		List<Product> returnedProductList = productServ.getAllProducts();
		
		Assertions.assertNotNull(returnedProductList);
		
	}
	
	@Test
	void testGetproductById() {
		Product mockProduct = new Product();
		long id = 1;
		
		Mockito.when(productRepo.findById(id)).thenReturn(Optional.of(mockProduct));
		
		Assertions.assertEquals(mockProduct, productServ.getProductById(id));
	}
	
	@Test
	void testGetProductByIdNotFound() {
		Optional<Product> mockProduct = java.util.Optional.empty();

		Mockito.when(productRepo.findById(1L)).thenReturn(mockProduct);
		
		Assertions.assertThrows(NotFoundException.class, () -> {
			productServ.getProductById(1);
		});
	}

	@Test
	void testUpdateProduct() {
		Product mockProduct = new Product();
		long id = 0;
		
		Mockito.when(productRepo.findById(id)).thenReturn(Optional.of(mockProduct));
		Mockito.when(productRepo.save(mockProduct)).thenReturn(mockProduct);
		
		Assertions.assertEquals(mockProduct, productServ.updateProduct(mockProduct));
		
	}

	@Test
	void testDeleteProduct() {
		Product mockProduct = new Product();
		mockProduct.setProductId(1);
		
		productRepo.deleteById(mockProduct.getProductId());
		
		Assertions.assertEquals(Optional.empty(), productRepo.findById(mockProduct.getProductId()));
	}
	
}
