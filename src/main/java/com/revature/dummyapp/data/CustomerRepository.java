package com.revature.dummyapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.dummyapp.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
