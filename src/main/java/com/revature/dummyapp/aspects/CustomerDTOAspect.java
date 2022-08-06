package com.revature.dummyapp.aspects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.dtos.CustomerDTO;



@Aspect
@Component
 public class CustomerDTOAspect {

	@Around("controllerMethodsReturningUser()")
	public Object userToUserDTO(ProceedingJoinPoint joinpoint) throws Throwable {
		@SuppressWarnings("unchecked")
		ResponseEntity<Customer> resp = (ResponseEntity<Customer>) joinpoint.proceed();
		
		Customer customer = resp.getBody();
		CustomerDTO customerDto = new CustomerDTO(customer);
		
		return ResponseEntity.status(resp.getStatusCode()).body(customerDto);
	}
	
	@Pointcut("execution(org.springframework.http.ResponseEntity<com.revature.dummyapp.models.Customer> com.revature.dummyapp.controllers..*(..))")
	public void controllerMethodsReturningUser() {}

 }