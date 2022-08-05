package com.revature.dummyapp.aspects;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.revature.dummyapp.auth.Auth;
import com.revature.dummyapp.exceptions.FailedAuthenticationException;
import com.revature.dummyapp.exceptions.TokenExpirationException;
import com.revature.dummyapp.models.dtos.CustomerDTO;
import com.revature.dummyapp.services.TokenService;

public class AuthAspect {
	private TokenService tokenServ;
	private HttpServletRequest currentReq;
	
	
	public AuthAspect(TokenService tokenServ, HttpServletRequest req) {
		this.tokenServ = tokenServ;
		this.currentReq = req;
	}

	@Around("methodsWithAuthAnnotation()")
	public Object authenticate(ProceedingJoinPoint joinpoint) throws Throwable {
		Auth authAnnotation = ((MethodSignature) joinpoint.getSignature())
				.getMethod()
				.getAnnotation(Auth.class);
		
		String jws = currentReq.getHeader("Auth");
		Optional<CustomerDTO> customerDtoOpt = Optional.empty();
		try {
			customerDtoOpt = tokenServ.validateToken(jws);
		} catch (FailedAuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token.");
		} catch (TokenExpirationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Expired token.");
		}
		
		if (!customerDtoOpt.isPresent()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No user info present.");
		}
	
		
		return joinpoint.proceed();
	}
	
	@Pointcut("@annotation(com.revature.dummyapp.auth.Auth)")
	public void methodsWithAuthAnnotation() {}


}
