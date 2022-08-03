package com.revature.dummyapp.models.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.revature.dummyapp.models.Customer;
import com.revature.dummyapp.models.Order;
import com.revature.dummyapp.models.Role;

/**
 * Customer DTO (Data Transfer Object) to prepare Customer object to be sent in HTTP
 * response
 * 
 * @author Devin
 */

public class CustomerDTO {
	/* Fields */
	private long id;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private Role role;
	private List<Order> orders;
	
	
	/* Constructors */
	public CustomerDTO() {
		super();
		this.id = 0;
		this.firstname = "";
		this.lastname = "";
		this.username = "";
		this.password = "";
		this.email = "";
		this.role = new Role();
		this.orders = new ArrayList<>();

	}



	public CustomerDTO(long id, String firstname, String lastname, String username, String password, String email, List<Order> orders) {
		super();
		setId(id);
		setFirstname(firstname);
		setLastname(lastname);
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setRole(new Role());
		setOrders(orders);

	}

	public CustomerDTO(long id, String firstname, String lastname, String username, String password, String email, Role role, List<Order> orders) {
		super();
		setId(id);
		setFirstname(firstname);
		setLastname(lastname);
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setRole(role);
		setOrders(orders);

	}

	
	public CustomerDTO(Customer customer) {
		super();
		setId(customer.getId());
		setFirstname(customer.getFirstname());
		setLastname(customer.getLastname());
		setEmail(customer.getEmail());
		setUsername(customer.getUsername());
		setPassword(customer.getPassword());
		setRole(customer.getRole());
		setOrders(customer.getOrders());
	}


	public CustomerDTO(int id, String username, Role role, List<Order> orders) {
		// TODO Auto-generated constructor stub
		super();
		setId(id);
		setUsername(username);
		setRole(new Role());
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, id, lastname, orders, password, role, username);
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
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + password + ", email=" + email + ", role=" + role + ", orders=" + orders
				+ "]";
	}



}
