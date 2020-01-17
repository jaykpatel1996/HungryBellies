package com.cuboulder.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cuboulder.models.RestaurantUser;

//takes care of all basic CRUD operations of RestaurantUser class

public interface RestaurantUserRepository extends CrudRepository<RestaurantUser, String>{

}
