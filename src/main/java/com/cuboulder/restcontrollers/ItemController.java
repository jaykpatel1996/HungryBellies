package com.cuboulder.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cuboulder.models.Item;
import com.cuboulder.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item")
	public List<Item> getAllItem(){
		return itemService.getAllItem();
	}
	
	@RequestMapping("/item/{id}")
	public Item getItem(@PathVariable String id){
		return itemService.getItem(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/item")
	public void addItem(@RequestBody Item item){
		 itemService.addItem(item);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/item/{id}")
	public void updateItem(@RequestBody Item item,@PathVariable String id){
		 itemService.updateItem(item,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/item/{id}")
	public void deleteItem(@PathVariable String id){
		 itemService.deleteItem(id);
	}
	
	
}
