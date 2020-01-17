package com.cuboulder.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cuboulder.models.Restaurant;


//takes care of all basic CRUD operations of Restaurant class

public interface RestaurantRepository extends CrudRepository<Restaurant, String>{

}
