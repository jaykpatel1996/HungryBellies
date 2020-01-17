package com.cuboulder.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuboulder.models.Address;
import com.cuboulder.repositories.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

//	private List<Address> addressList = new ArrayList<>(Arrays.asList(new Address("1","daaa","sdds","Boulder","Colorado","354343"),
//			new Address("2","2daaa","2sdds","2Boulder","2Colorado","2354343")));
//	
	public List<Address> getAllAddress() {
		
	//	return addressList;
		return (List<Address>) addressRepository.findAll();
	}

	public Address getAddress(String id) {
		
		//return addressList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return addressRepository.findOne(id);
	}

	public void addAddress(Address address) {
		//addressList.add(address);
		addressRepository.save(address);
	}

	public void updateAddress(Address address, String id) {
		/*
		 * for(int i=0;i<addressList.size();i++) { Address a = addressList.get(i);
		 * 
		 * if(a.getId().equals(id)) { addressList.set(i,address); return; } }
		 */
		addressRepository.save(address);
		
	}

	public void deleteAddress(String id) {
		addressRepository.delete(id);
	}

}
