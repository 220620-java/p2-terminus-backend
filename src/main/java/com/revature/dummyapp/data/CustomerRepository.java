package com.revature.dummyapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.dummyapp.models.Customer;

/**
 * 
 * @author Tony Wiedman
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	public Customer findByUsername(String username);
}
