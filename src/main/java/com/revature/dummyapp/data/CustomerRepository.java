package com.revature.dummyapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.dummyapp.models.Customer;

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
 * 
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	/**
	 * Retrieves Customer from the database based on the
	 * username
	 * 
	 * @param username
	 * @return
	 */
	public Customer findByUsername(String username);
}
