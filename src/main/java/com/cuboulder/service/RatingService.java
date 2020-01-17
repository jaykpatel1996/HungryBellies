package com.cuboulder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuboulder.models.Rating;
import com.cuboulder.repositories.RatingRepository;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;

//	private List<Rating> ratingList = new ArrayList<>(Arrays.asList(new Rating("1","daaa","sdds","Boulder","Colorado","354343"),
//			new Rating("2","2daaa","2sdds","2Boulder","2Colorado","2354343")));
//	
	public List<Rating> getAllRating() {
		
	//	return ratingList;
		return (List<Rating>) ratingRepository.findAll();
	}

	public Rating getRating(String id) {
		
		//return ratingList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return ratingRepository.findOne(id);
	}

	public void addRating(Rating rating) {
		//ratingList.add(rating);
		ratingRepository.save(rating);
	}

	

}
