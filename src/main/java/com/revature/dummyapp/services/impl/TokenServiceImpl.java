package com.revature.dummyapp.services.impl;
import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.dtos.CustomerDTO;
import com.revature.dummyapp.services.TokenService;


@Service
public class TokenServiceImpl implements TokenService {

	@Override
	public String createToken(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CustomerDTO> validateToken(String token) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int getDefaultExpiration() {
		// TODO Auto-generated method stub
		return 0;
	}
}
