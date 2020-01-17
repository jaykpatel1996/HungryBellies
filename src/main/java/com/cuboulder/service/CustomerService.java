package com.cuboulder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuboulder.models.Customer;
import com.cuboulder.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

//	private List<Customer> customerList = new ArrayList<>(Arrays.asList(new Customer("1","daaa","sdds","Boulder","Colorado","354343"),
//			new Customer("2","2daaa","2sdds","2Boulder","2Colorado","2354343")));
//	
	public List<Customer> getAllCustomer() {
		
	//	return customerList;
		return (List<Customer>) customerRepository.findAll();
	}

	public Customer getCustomer(String id) {
		
		//return customerList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return customerRepository.findOne(id);
	}

	public void addCustomer(Customer customer) {
		//customerList.add(customer);
		customerRepository.save(customer);
	}

	public void updateCustomer(Customer customer, String id) {
		/*
		 * for(int i=0;i<customerList.size();i++) { Customer a = customerList.get(i);
		 * 
		 * if(a.getId().equals(id)) { customerList.set(i,customer); return; } }
		 */
		customerRepository.save(customer);
		
	}

	public void deleteCustomer(String id) {
		customerRepository.delete(id);
	}

	public Customer getCustomerLogin(String email) {
		
		return  customerRepository.findByEmaiId(email);
	}

}
