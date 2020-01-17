package com.cuboulder.models;

import javax.persistence.Entity;

import javax.persistence.Id;


//this class  to store reviews of restaurant


@Entity
public class Review {

	
	@Id
	private String id;
	
	private String reviewDescription;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReviewDescription() {
		return reviewDescription;
	}

	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}
	
	

}
