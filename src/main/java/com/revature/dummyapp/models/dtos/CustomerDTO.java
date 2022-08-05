package com.revature.dummyapp.models.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.Order;

/**
 * Customer DTO (Data Transfer Object) to prepare Customer object to be sent in
 * HTTP response
 * 
 * @author Devin
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
	public CustomerDTO() {
		super();
		this.id = 0;
		this.firstname = "";
		this.lastname = "";
		this.username = "";
		this.email = "";
		this.orders = new ArrayList<>();

	}

	public CustomerDTO(long id, String firstname, String lastname, String username, String email, List<Order> orders) {
		super();
		setId(id);
		setFirstname(firstname);
		setLastname(lastname);
		setUsername(username);
		setEmail(email);
		setOrders(orders);

	}

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
		// TODO Auto-generated constructor stub
		super();
		setId(id);
		setUsername(username);
		setOrders(orders);

	}

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

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, id, lastname, orders, username);
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
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(lastname, other.lastname) && Objects.equals(orders, other.orders)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", orders=" + orders + "]";
	}

}
