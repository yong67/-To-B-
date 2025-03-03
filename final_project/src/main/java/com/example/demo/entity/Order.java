package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderID;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="e-mail", nullable=false)
	private String email;
	
	@Column(name="phoneNumber", nullable=false)
	private String phoneNumber;
	
	@Column(name="company", nullable=false)
	private String company;
	
	@Column(name="address", nullable=false)
	private String address;
	
	@Column(name="comments", nullable=false)
	private String comments;
	
	@Column(name="productName", nullable=false)
	private String productName;
	
	@Column(name="productQuantity", nullable=false)
	private Long productQuantity;
	
	public Order() {
	}

	public Order(String name, String email, String phoneNumber, String company, String address, String comments,
			String productName, Long productQuantity) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.company = company;
		this.address = address;
		this.comments = comments;
		this.productName = productName;
		this.productQuantity = productQuantity;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}
	
}
