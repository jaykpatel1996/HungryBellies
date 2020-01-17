package com.cuboulder.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cuboulder.models.Customer;
import com.cuboulder.models.FoodOrder;
import com.cuboulder.service.CustomerService;
import com.cuboulder.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	
	@RequestMapping("/order")
	public List<FoodOrder> getAllOrder(){
		return orderService.getAllOrder();
	}
	
	@RequestMapping("/order/{id}")
	public FoodOrder getOrder(@PathVariable String id){
		return orderService.getOrder(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/order")
	public void addOrder(@RequestBody FoodOrder order){
		 orderService.addOrder(order);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/order/{id}")
	public void deleteOrder(@PathVariable String id){
		 orderService.deleteOrder(id);
	}
	
	
	}
