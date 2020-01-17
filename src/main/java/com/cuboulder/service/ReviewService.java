package com.cuboulder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuboulder.models.Review;
import com.cuboulder.repositories.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;

//	private List<Review> reviewList = new ArrayList<>(Arrays.asList(new Review("1","daaa","sdds","Boulder","Colorado","354343"),
//			new Review("2","2daaa","2sdds","2Boulder","2Colorado","2354343")));
//	
	public List<Review> getAllReview() {
		
	//	return reviewList;
		return (List<Review>) reviewRepository.findAll();
	}

	public Review getReview(String id) {
		
		//return reviewList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return reviewRepository.findOne(id);
	}

	public void addReview(Review review) {
		//reviewList.add(review);
		reviewRepository.save(review);
	}

	

}
