package com.revature.dummyapp.models.dtos;

import java.util.List;

import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.Order;

/**
 * Customer DTO (Data Transfer Object) to prepare Customer object to be sent in HTTP
 * response
 * 
 * @author Devin Abreu
 */
public class CustomerDTO {
	/* Fields */
	private long id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private List<Order> orders;
	
	/* Constructors */

	public CustomerDTO(Customer customer) {
		super();
		setId(customer.getId());
		setFirstname(customer.getFirstname());
		setLastname(customer.getLastname());
		setEmail(customer.getEmail());
		setUsername(customer.getUsername());
		setOrders(customer.getOrders());
	}

	public CustomerDTO(int id, String username, List<Order> orders) {
		super();
		setId(id);
		setUsername(username);
		setOrders(orders);

	}
	
	/* Public Methods (Getters and Setters) */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void setToken(String jws) {
		
	}
	
}
