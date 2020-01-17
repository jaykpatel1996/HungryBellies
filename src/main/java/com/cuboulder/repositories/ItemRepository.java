package com.cuboulder.repositories;

import org.springframework.data.repository.CrudRepository;


import com.cuboulder.models.Item;


//takes care of all basic CRUD operations of Item class

public interface ItemRepository extends CrudRepository<Item, String>{

}
