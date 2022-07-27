package com.revature.dummyapp.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = " firtsname")
	private String firstname;
	@Column(name = " lastname")
	private String lastname;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;

	public long getCustomerId() {
		return id;
	}

	public void setCustomerId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname(){
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public int hashCode() {
		return Objects.hash(email, id, username, password, firstname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(username, other.username)
				&& Objects.equals(password, other.password) && Objects.equals(firstname, other.firstname);
	}

	@Override
	public String toString() {
		return "coustomer [id=" + id + ", firstname=" + firstname + ",lastName= " + lastname + ", password=" + password + ", name=" + username + ", email="
				+ email + "]";
	}
	
	

	
	
}
