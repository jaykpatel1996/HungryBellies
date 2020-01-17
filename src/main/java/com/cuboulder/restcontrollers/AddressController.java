package com.cuboulder.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cuboulder.models.Address;
import com.cuboulder.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@RequestMapping("/address")
	public List<Address> getAllAddress(){
		return addressService.getAllAddress();
	}
	
	@RequestMapping("/address/{id}")
	public Address getAddress(@PathVariable String id){
		return addressService.getAddress(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/address")
	public void addAddress(@RequestBody Address address){
		 addressService.addAddress(address);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/address/{id}")
	public void updateAddress(@RequestBody Address address,@PathVariable String id){
		 addressService.updateAddress(address,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/address/{id}")
	public void deleteAddress(@PathVariable String id){
		 addressService.deleteAddress(id);
	}
	
	
}
