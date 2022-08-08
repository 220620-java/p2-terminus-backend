package com.revature.dummyapp.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dummyapp.models.Product;
import com.revature.dummyapp.models.dtos.ProductDTO;
import com.revature.dummyapp.services.ProductService;

@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {
	
	@MockBean
	private ProductService productServ;
		
	@Autowired
	private MockMvc mockMvc;
		
	private ObjectMapper jsonMapper = new ObjectMapper();
	
	@Test
	void testSaveProduct() throws JsonProcessingException, Exception {
		Product mockProduct = new Product();
		Product mockProductWithId = new Product();
		mockProductWithId.setOrderId(1);
		
		Mockito.when(productServ.saveProduct(mockProduct)).thenReturn(mockProductWithId);
		
		mockMvc.perform(post("/product").contentType(MediaType.APPLICATION_JSON)
				.content(jsonMapper.writeValueAsString(mockProduct)))
				.andExpect(status().isCreated())
				.andExpect(content().json(jsonMapper.writeValueAsString(new ProductDTO(mockProductWithId))));
	}
	
	@Test
	void testGetAllProducts() throws JsonProcessingException, Exception {
		List<Product> mockProducts = new ArrayList<>();
		
		Mockito.when(productServ.getAllProducts()).thenReturn(mockProducts);
		
		mockMvc.perform(get("/product")).andExpect(status().isOk())
										 .andExpect(content().json(jsonMapper.writeValueAsString(mockProducts)));
	}
	
	@Test
	void testGetProductById() throws JsonProcessingException, Exception {
		Product mockProduct = new Product();
		
		Mockito.when(productServ.getProductById(1)).thenReturn(mockProduct);
		
		mockMvc.perform(get("/product/1"))
					.andExpect(status().isOk())
					.andExpect(content().json(jsonMapper.writeValueAsString(new ProductDTO(mockProduct))));
		
	}
	
	@Test
	void testUpdateproduct() throws JsonProcessingException, Exception {
		Product mockProduct = new Product();
		mockProduct.setProductId(1);
		
		Mockito.when(productServ.updateProduct(mockProduct)).thenReturn(mockProduct);
		
		mockMvc.perform(put("/product/1").contentType(MediaType.APPLICATION_JSON)
									.content(jsonMapper.writeValueAsString(mockProduct)))
									.andExpect(status().isOk())
									.andExpect(content().json(jsonMapper.writeValueAsString(new ProductDTO(mockProduct))));
		
	}
	
	@Test
	void testUpdateNullProduct() throws JsonProcessingException, Exception {
		Product mockProduct = new Product();
		mockProduct.setProductId(1);
		
		Mockito.when(productServ.updateProduct(mockProduct)).thenReturn(null);
		
		mockMvc.perform(put("/product/1").contentType(MediaType.APPLICATION_JSON)
				                        .content(jsonMapper.writeValueAsString(mockProduct)))
		                                .andExpect(status().isBadRequest());
	}
	
	@Test
    void updateProductConflict() throws JsonProcessingException, Exception {
		Product mockProduct = new Product();
		mockProduct.setProductId(1);
		
		mockMvc.perform(put("/product/2")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonMapper.writeValueAsString(mockProduct)))
			.andExpect(status().isConflict());
	}
	
	@Test
	void testDeleteProduct() throws Exception {
	
		ResultActions response = mockMvc.perform(delete("/product/1"));
		
		response.andExpect(status().isOk()).andDo(print());
	}
	
	
}
