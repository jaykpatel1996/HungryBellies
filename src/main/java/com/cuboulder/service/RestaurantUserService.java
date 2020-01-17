package com.cuboulder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuboulder.models.RestaurantUser;
import com.cuboulder.repositories.RestaurantUserRepository;

@Service
public class RestaurantUserService {
	
	@Autowired
	private RestaurantUserRepository restaurantUserRepository;

//	private List<RestaurantUser> restaurantUserList = new ArrayList<>(Arrays.asList(new RestaurantUser("1","daaa","sdds","Boulder","Colorado","354343"),
//			new RestaurantUser("2","2daaa","2sdds","2Boulder","2Colorado","2354343")));
//	
	public List<RestaurantUser> getAllRestaurantUser() {
		
	//	return restaurantUserList;
		return (List<RestaurantUser>) restaurantUserRepository.findAll();
	}

	public RestaurantUser getRestaurantUser(String id) {
		
		//return restaurantUserList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return restaurantUserRepository.findOne(id);
	}

	public void addRestaurantUser(RestaurantUser restaurantUser) {
		//restaurantUserList.add(restaurantUser);
		restaurantUserRepository.save(restaurantUser);
	}

	public void updateRestaurantUser(RestaurantUser restaurantUser, String id) {
		/*
		 * for(int i=0;i<restaurantUserList.size();i++) { RestaurantUser a = restaurantUserList.get(i);
		 * 
		 * if(a.getId().equals(id)) { restaurantUserList.set(i,restaurantUser); return; } }
		 */
		restaurantUserRepository.save(restaurantUser);
		
	}

	public void deleteRestaurantUser(String id) {
		restaurantUserRepository.delete(id);
	}

}
