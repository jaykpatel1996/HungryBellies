package com.cuboulder.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cuboulder.models.FoodOrder;

//takes care of all basic CRUD operations of FoodOrder class

public interface OrderRepository extends CrudRepository<FoodOrder, String>{

}
