package com.cuboulder.models;

import javax.persistence.Entity;
import javax.persistence.Id;


// class to store rating of items

@Entity
public class Rating {

	
	@Id
	private String id;

	private int noOfStars;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNoOfStars() {
		return noOfStars;
	}

	public void setNoOfStars(int noOfStars) {
		this.noOfStars = noOfStars;
	}
	
	
	
	
}
