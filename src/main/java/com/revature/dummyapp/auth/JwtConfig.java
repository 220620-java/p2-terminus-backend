package com.revature.dummyapp.auth;


import java.security.Key;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtConfig {
	
	/**
	 * retrieves the jwt secret from environment variables
	 * 
	 */
	private String salt = System.getenv("JWT_SECRET");

	
	/**
	 * Calculating the number of milliseconds in a day using
	 * Spring expression language (SpEL)
	 * 
	 */
	@Value("#{24*60*60*1000}")
	private int expiration;
	
	/**
	 * Using RS256 algorithm which requires 540-character (2048 bit) key
	 * 
	 */
	private final SignatureAlgorithm sigAlg = SignatureAlgorithm.HS256;
	private Key signingKey;

	@PostConstruct
	public void createKey() {
		byte[] saltyBytes = DatatypeConverter.parseBase64Binary(salt);
		signingKey = new SecretKeySpec(saltyBytes, sigAlg.getJcaName());
	}
	
	/**
	 * 
	 * @return expiration time
	 */
	public int getExpiration() {
		return this.expiration;
	}
	
	/**
	 * 
	 * @return jwt signature algorithm
	 */
	public SignatureAlgorithm getSigAlg() {
		return this.sigAlg;
	}
	
	/**
	 * 
	 * @return jwt signing key
	 */
	public Key getSigningKey() {
		return this.signingKey;
	}

}
