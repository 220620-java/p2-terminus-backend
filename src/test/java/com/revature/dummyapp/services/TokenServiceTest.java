package com.revature.dummyapp.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.dummyapp.DummyMainApplication;
import com.revature.dummyapp.auth.JwtConfig;
import com.revature.dummyapp.exceptions.FailedAuthenticationException;
import com.revature.dummyapp.models.Customer;

import io.jsonwebtoken.Jwts;

@SpringBootTest(classes = DummyMainApplication.class)
class TokenServiceTest {
	@Autowired
	private JwtConfig jwtConfig;
	
	@Autowired
	private TokenService tokenServ;
	
	@Test
	void testCreateToken() {
		Customer customer = new Customer();
		String jws = tokenServ.createToken(customer);
		
		Assertions.assertDoesNotThrow(() -> {
			Jwts.parserBuilder().setSigningKey(jwtConfig.getSigningKey()).build().parseClaimsJws(jws);
		});
	}
	
	@Test
	void testCreateTokenNullUser() {
		Assertions.assertEquals("", tokenServ.createToken(null));
	}
	
	@Test
	void testCreateTokenInvalidCustomer() {
		Assertions.assertEquals("", tokenServ.createToken(new Customer(null, null)));
	}
	
//	@Test
//	void testValidateToken() {
//		String validToken = Jwts.builder().setId("1")
//										  .setSubject("test")
//										  .signWith(jwtConfig.getSigningKey())
//										  .compact();
//		
//		Assertions.assertDoesNotThrow(() -> {
//			tokenServ.validateToken(validToken);
//		});
//	}
//	
	@Test
	void testInvalidToken() {
		Assertions.assertThrows(FailedAuthenticationException.class, () -> {
			tokenServ.validateToken("invalidToken");
		});
	}

}
