package com.revature.dummyapp.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.dummyapp.models.Product;

/**
 * Replaces DAO as the interface that handles objects across the database
 * 
 * @author Devin
 * @author Tony Wiedman
 *
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByOrderId(long id);
	// provides basic CRUD operations for products

//	public Product findById(long productId);
//	public List<Product> findByCustomer(Customer customer);

}
