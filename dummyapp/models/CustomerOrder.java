package com.revature.dummyapp.models;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customerorder")

public class CustomerOrder {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerorder_id")
	private long id;
	
	@OneToMany
	@JoinColumn(name="customer_id") // defines foreign key relationship between Customerorder and Orders
	private List<Customer> customers;
	 
	@OneToMany
	@JoinColumn(name="order_id") // defines foreign key relationship between Customerorder and Orders
	private List<Order> orders;
	
}
