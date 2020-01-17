package com.cuboulder.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cuboulder.models.Review;

//takes care of all basic CRUD operations of Review class

public interface ReviewRepository extends CrudRepository<Review, String>{

}
