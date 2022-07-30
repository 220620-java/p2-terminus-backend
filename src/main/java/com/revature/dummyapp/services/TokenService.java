package com.revature.dummyapp.services;

import java.util.Optional;

import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.dtos.CustomerDTO;

/**
 * 
 * @author Tony Wiedman
 *
 */
public interface TokenService {
	/**
	 * 
	 * @param customer
	 * @return
	 */
	public String createToken(Customer customer);

	/**
	 * 
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public Optional<CustomerDTO> validateToken(String token) throws Exception;

	/**
	 * 
	 * @return
	 */
	public int getDefaultExpiration();

}
