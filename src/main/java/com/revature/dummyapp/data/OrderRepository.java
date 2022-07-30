package com.revature.dummyapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.dummyapp.models.Order;

/**
 * 
 * @author Tony Wiedman
 * @author Devin
 *
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
