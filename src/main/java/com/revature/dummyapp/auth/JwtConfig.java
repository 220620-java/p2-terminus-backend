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
	
	private String salt = System.getenv("JWT_SECRET");

	
	@Value("#{24*60*60*1000}")
	private int expiration;
	
	private final SignatureAlgorithm sigAlg = SignatureAlgorithm.HS256;
	private Key signingKey;


	@PostConstruct
	public void createKey() {
		byte[] saltyBytes = DatatypeConverter.parseBase64Binary(salt);
		signingKey = new SecretKeySpec(saltyBytes, sigAlg.getJcaName());
	}

	public int getExpiration() {
		return this.expiration;
	}
	
	public SignatureAlgorithm getSigAlg() {
		return this.sigAlg;
	}
	
	public Key getSigningKey() {
		return this.signingKey;
	}

}