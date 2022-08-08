package com.revature.dummyapp.services.impl;
import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.dummyapp.auth.JwtConfig;
import com.revature.dummyapp.exceptions.FailedAuthenticationException;
import com.revature.dummyapp.exceptions.TokenExpirationException;
import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.dtos.CustomerDTO;
import com.revature.dummyapp.services.TokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

/**
 * @author Tony Wiedman
 * @author Devin Abreu
 * @author Berhanu Seyoum
 * @author Noah Cavazos
 * 
 */
@Service
public class TokenServiceImpl implements TokenService {
	
private JwtConfig jwtConfig;
	
	public TokenServiceImpl(JwtConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
	}

	@Override
	public String createToken(Customer customer) {
		String jws = "";
		
		if (customer != null && customer.getUsername() != null) {
			long now = System.currentTimeMillis();
			
			jws = Jwts.builder()
					.setId(String.valueOf(customer.getId()))
					.setSubject(customer.getUsername())
					.claim("role", "user")
					.setIssuer("terminus")
					.setIssuedAt(new Date(now))
					.setExpiration(new Date(now + jwtConfig.getExpiration()))
					.signWith(jwtConfig.getSigningKey())
					.compact();
		}
		return jws;

	}

	@Override
	public Optional<CustomerDTO> validateToken(String token) throws TokenExpirationException, FailedAuthenticationException {
		try {
			Claims jwtClaims = Jwts.parserBuilder()
				.setSigningKey(jwtConfig.getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
			
			long now = System.currentTimeMillis();
			
			if (jwtClaims.getExpiration().before(new Date(now))) {
				throw new TokenExpirationException();
			}
			
			CustomerDTO customerDto = parseCustomer(jwtClaims);
			return Optional.of(customerDto);
			
		} catch (JwtException e) {
			throw new FailedAuthenticationException();
		}

	}

	@Override
	public int getDefaultExpiration() {
		return jwtConfig.getExpiration();
	}
	
	private CustomerDTO parseCustomer(Claims claims) {
		int id = Integer.parseInt(claims.getId());
		String username = claims.getSubject();
		
		return new CustomerDTO(id, username, null);
	}

}
