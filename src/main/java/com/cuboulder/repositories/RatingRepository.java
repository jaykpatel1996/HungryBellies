package com.cuboulder.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cuboulder.models.Rating;

//takes care of all basic CRUD operations of Rating class

public interface RatingRepository extends CrudRepository<Rating, String>{

}
