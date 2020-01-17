package com.cuboulder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuboulder.models.Restaurant;
import com.cuboulder.repositories.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;

//	private List<Restaurant> restaurantList = new ArrayList<>(Arrays.asList(new Restaurant("1","daaa","sdds","Boulder","Colorado","354343"),
//			new Restaurant("2","2daaa","2sdds","2Boulder","2Colorado","2354343")));
//	
	public List<Restaurant> getAllRestaurant() {
		
	//	return restaurantList;
		return (List<Restaurant>) restaurantRepository.findAll();
	}

	public Restaurant getRestaurant(String id) {
		
		//return restaurantList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return restaurantRepository.findOne(id);
	}

	public void addRestaurant(Restaurant restaurant) {
		//restaurantList.add(restaurant);
		restaurantRepository.save(restaurant);
	}

	public void updateRestaurant(Restaurant restaurant, String id) {
		/*
		 * for(int i=0;i<restaurantList.size();i++) { Restaurant a = restaurantList.get(i);
		 * 
		 * if(a.getId().equals(id)) { restaurantList.set(i,restaurant); return; } }
		 */
		restaurantRepository.save(restaurant);
		
	}

	public void deleteRestaurant(String id) {
		restaurantRepository.delete(id);
	}

	public List<Restaurant> getAllRestaurant(String name) {
		//System.out.println("-----getAll-----------");
		 List<Restaurant> rs = (List<Restaurant>) restaurantRepository.findAll();
		 List<Restaurant> r = new ArrayList<Restaurant>();
		 
		 for(int i=0;i<rs.size();i++) {
			 if(rs.get(i).getName().contains(name)) r.add(rs.get(i));
		 }
		// System.out.println(r);
		 return r;
	}

}
