package com.revature.dummyapp.models.dtos;

import java.util.Objects;

import com.revature.dummyapp.models.Customer;

/**
 * DTO (Data Transfer Object) to prepare Customer object to be sent in HTTP
 * response
 * 
 * @author Devin
 */

public class CustomerDTO {
	/* Fields */
	private long customerId;
	private String username;
	private String email;

	/* Constructors */
	public CustomerDTO() {
		this.customerId = 0;
		this.username = "";
		this.email = "";
	}

	public CustomerDTO(long id, String username, String email) {
		this.customerId = id;
		this.username = username;
		this.email = email;
	}

	public CustomerDTO(Customer customer) {
		setCustomerId(customer.getCustomerId());
		setUsername(customer.getUsername());
		setEmail(customer.getEmail());

	}

	/* Public Methods (Getters & Setters) */

	/**
	 * 
	 * @return long
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * 
	 * @param customerId
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * 
	 * @return String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, email, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return customerId == other.customerId && Objects.equals(email, other.email)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", username=" + username + ", email=" + email + "]";
	}

}
