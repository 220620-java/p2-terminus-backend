package com.revature.dummyapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.dummyapp.models.Product;

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
 * 
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
