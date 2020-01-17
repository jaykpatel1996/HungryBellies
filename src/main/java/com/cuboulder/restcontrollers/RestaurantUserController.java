package com.cuboulder.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cuboulder.models.RestaurantUser;
import com.cuboulder.service.RestaurantUserService;


@RestController
public class RestaurantUserController {

	@Autowired
	private RestaurantUserService restaurantUserService;
	
	@RequestMapping("/restaurantUser")
	public List<RestaurantUser> getAllRestaurantUser(){
		return restaurantUserService.getAllRestaurantUser();
	}
	
	@RequestMapping("/restaurantUser/{id}")
	public RestaurantUser getRestaurantUser(@PathVariable String id){
		return restaurantUserService.getRestaurantUser(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/restaurantUser")
	public void addRestaurantUser(@RequestBody RestaurantUser restaurantUser){
		restaurantUserService.addRestaurantUser(restaurantUser);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/restaurantUser/{id}")
	public void updateRestaurantUser(@RequestBody RestaurantUser restaurantUser,@PathVariable String id){
		restaurantUserService.updateRestaurantUser(restaurantUser,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/restaurantUser/{id}")
	public void deleteRestaurantUser(@PathVariable String id){
		restaurantUserService.deleteRestaurantUser(id);
	}
	
	
}
