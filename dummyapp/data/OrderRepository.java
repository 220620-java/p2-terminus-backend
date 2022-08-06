package com.revature.dummyapp.data;
<<<<<<< HEAD
 

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

import com.revature.dummyapp.models.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
     
    public Order findByUseOrder(String username);

}

=======

import com.revature.dummyapp.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
>>>>>>> cb1e50a3ad9c79434cf4a166b81c06ee64dba329
=======

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.dummyapp.models.Order;

/**
 * 
 * @author Tony Wiedman
 * @author Devin
 * @author Berhanu
 *
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
>>>>>>> main
