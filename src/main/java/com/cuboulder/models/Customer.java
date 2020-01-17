package com.cuboulder.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


//Customer class to store user profile details

@Entity
public class Customer {


	@Id
	private String id;
	

	@OneToMany(cascade=CascadeType.ALL)
	private List<Address> address;

	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;
	
	private String emaiId;
	
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<FoodOrder> listOfOrders;
	
	
	public List<FoodOrder> getListOfOrders() {
		return listOfOrders;
	}


	public void setListOfOrders(List<FoodOrder> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	private Date createdAt;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmaiId() {
		return emaiId;
	}


	public void setEmaiId(String emaiId) {
		this.emaiId = emaiId;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
	
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	
	
	
}
