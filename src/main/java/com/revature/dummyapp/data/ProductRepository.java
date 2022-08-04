package com.revature.dummyapp.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.dummyapp.models.Order;
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

	Optional<Order> findByOrderId(long orderId);}
