package com.cuboulder.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuboulder.models.Restaurant;
import com.cuboulder.models.Review;
import com.cuboulder.service.RestaurantService;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping("/restaurant")
	public List<Restaurant> getAllRestaurant(){
		//System.out.println("----------------------------------------------------");
		return restaurantService.getAllRestaurant();
	}
	
	@RequestMapping("/restaurant/{id}")
	public Restaurant getRestaurant(@PathVariable String id){
		//System.out.println("----------------------------------------------------");
		return restaurantService.getRestaurant(id);
	}
	
	//@RequestMapping("/restaurant/{name}")
	@RequestMapping("/restaurants")
	public List<Restaurant> getAllRestaurant(@RequestParam(value="name") String name){
		//System.out.println("----------------------------------------------------");
		return restaurantService.getAllRestaurant(name);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/restaurant")
	public void addRestaurant(@RequestBody Restaurant restaurant){
		 restaurantService.addRestaurant(restaurant);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/restaurantReview/{id}")
	public void addRestaurant(@RequestBody Review review,@PathVariable String id){
		 Restaurant rw = restaurantService.getRestaurant(id);
		 List<Review> re  = rw.getReviews();
		 re.add(review);
		 
		 rw.setReviews(re);
		 restaurantService.updateRestaurant(rw, rw.getId());
	}
	
	
	
	@RequestMapping(method=RequestMethod.PUT,value="/restaurant/{id}")
	public void updateRestaurant(@RequestBody Restaurant restaurant,@PathVariable String id){
		restaurantService.updateRestaurant(restaurant,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/restaurant/{id}")
	public void deleteRestaurant(@PathVariable String id){
		restaurantService.deleteRestaurant(id);
	}
	
	
	
}
