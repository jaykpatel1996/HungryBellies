package com.cuboulder.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cuboulder.models.Customer;
import com.cuboulder.models.FoodOrder;
import com.cuboulder.service.CustomerService;


@RestController
public class CustomerController2 {

	@Autowired
	private CustomerService customerService;
	
	
	//@CrossOrigin(origins="*", methods= {RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.GET,RequestMethod.DELETE})
	@RequestMapping(method=RequestMethod.POST,value="/customer_order/")
	public void updateCustomerOrder(@RequestBody FoodOrder foodOrder,@RequestHeader("mad") String email){

		System.out.println("Email : "+email);
				
		
		Customer cust = customerService.getCustomerLogin(email);
		
		List<FoodOrder> fd = cust.getListOfOrders();
		fd.add(foodOrder);
		
		cust.setListOfOrders(fd);
		
		customerService.updateCustomer(cust,cust.getId());
		
	//	return cust;
	}
	
	

	
}
