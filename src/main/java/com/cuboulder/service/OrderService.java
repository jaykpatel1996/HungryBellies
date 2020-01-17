package com.cuboulder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuboulder.models.FoodOrder;

import com.cuboulder.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

//	private List<Order> orderList = new ArrayList<>(Arrays.asList(new Order("1","daaa","sdds","Boulder","Colorado","354343"),
//			new Order("2","2daaa","2sdds","2Boulder","2Colorado","2354343")));
//	
	public List<FoodOrder> getAllOrder() {
		
	//	return orderList;
		return (List<FoodOrder>) orderRepository.findAll();
	}

	public FoodOrder getOrder(String id) {
		
		//return orderList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return orderRepository.findOne(id);
	}

	public void addOrder(FoodOrder order) {
		//orderList.add(order);
		orderRepository.save(order);
	}


	public void deleteOrder(String id) {
		orderRepository.delete(id);
	}

}
