package com.cuboulder.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cuboulder.models.Address;

// takes care of all basic CRUD operations of Address class

public interface AddressRepository extends CrudRepository<Address, String>{

}
