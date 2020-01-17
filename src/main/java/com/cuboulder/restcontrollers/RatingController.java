package com.cuboulder.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cuboulder.models.Rating;
import com.cuboulder.service.RatingService;

@RestController
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@RequestMapping("/rating")
	public List<Rating> getAllRating(){
		return ratingService.getAllRating();
	}
	
	@RequestMapping("/rating/{id}")
	public Rating getRating(@PathVariable String id){
		return ratingService.getRating(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/rating")
	public void addRating(@RequestBody Rating rating){
		 ratingService.addRating(rating);
	}
	
	
}
