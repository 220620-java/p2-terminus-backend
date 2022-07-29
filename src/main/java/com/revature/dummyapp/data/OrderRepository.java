package com.revature.dummyapp.data;
 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.dummyapp.models.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
     
    public Order findByUseOrder(String username);

}

