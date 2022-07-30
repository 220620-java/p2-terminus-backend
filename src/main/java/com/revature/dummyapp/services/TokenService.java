package com.revature.dummyapp.services;
import java.util.Optional;

import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.dtos.CustomerDTO;

public interface TokenService {
	public String createToken(Customer customer);
	public Optional<CustomerDTO> validateToken(String token) throws Exception;
	public int getDefaultExpiration();

}
