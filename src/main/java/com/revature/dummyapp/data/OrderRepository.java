package com.revature.dummyapp.data;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.dummyapp.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{




} 
