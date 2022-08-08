package com.revature.dummyapp.services;

import java.util.Optional;

import com.revature.dummyapp.exceptions.FailedAuthenticationException;
import com.revature.dummyapp.exceptions.TokenExpirationException;
import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.dtos.CustomerDTO;

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
 * 
 */
public interface TokenService {
	/**
	 * Creates a new jwt token based on customers
	 * credentials
	 * 
	 * @param customer
	 * @return
	 */
	public String createToken(Customer customer);

	/**
	 * Validates token provided to ensure token matches
	 * 
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public Optional<CustomerDTO> validateToken(String token) throws FailedAuthenticationException, TokenExpirationException;

	/**
	 * 
	 * @return
	 */
	public int getDefaultExpiration();

}
