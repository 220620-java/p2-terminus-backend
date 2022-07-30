package com.revature.dummyapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Tony Wiedman
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String reqResource, field;
	private Object value;
	
	public NotFoundException(String reqResource, String field, Object value) {
		super(String.format("%s could not be located with %s : '%s'", reqResource, field, value));
		this.reqResource = reqResource;
		this.field = field;
		this.value = value;
	}
	
	public String getReqResource() {
		return reqResource;
	}
	
	public String getField() {
		return field;
	}
	
	public Object getValue() {
		return value;
	}
}
