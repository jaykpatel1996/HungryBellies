package com.cuboulder.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cuboulder.models.Review;
import com.cuboulder.service.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/review")
	public List<Review> getAllReview(){
		return reviewService.getAllReview();
	}
	
	@RequestMapping("/review/{id}")
	public Review getReview(@PathVariable String id){
		return reviewService.getReview(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/review")
	public void addReview(@RequestBody Review review){
		 reviewService.addReview(review);
	}
	
	
}
