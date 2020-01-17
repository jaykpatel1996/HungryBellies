package com.cuboulder.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

// class to store restaurant details

@Entity
public class Restaurant {
	
	@Id
	private String id;
	
	private String name;

	private String address;
	
	
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Item> listOfItems;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Rating rating;
	

	@OneToMany(cascade=CascadeType.ALL)
	private List<Review> reviews;
	
	private Timestamp openTime;
	
	
	private Timestamp closeTime;
	
	private Date createdAt;



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public List<Item> getListOfItems() {
		return listOfItems;
	}



	public void setListOfItems(List<Item> listOfItems) {
		this.listOfItems = listOfItems;
	}



	public Rating getRating() {
		return rating;
	}



	public void setRating(Rating rating) {
		this.rating = rating;
	}



	public List<Review> getReviews() {
		return reviews;
	}



	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}



	public Timestamp getOpenTime() {
		return openTime;
	}



	public void setOpenTime(Timestamp openTime) {
		this.openTime = openTime;
	}



	public Timestamp getCloseTime() {
		return closeTime;
	}



	public void setCloseTime(Timestamp closeTime) {
		this.closeTime = closeTime;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	

}
