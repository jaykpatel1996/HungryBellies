package com.cuboulder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuboulder.models.Item;
import com.cuboulder.repositories.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

//	private List<Item> itemList = new ArrayList<>(Arrays.asList(new Item("1","daaa","sdds","Boulder","Colorado","354343"),
//			new Item("2","2daaa","2sdds","2Boulder","2Colorado","2354343")));
//	
	public List<Item> getAllItem() {
		
	//	return itemList;
		return (List<Item>) itemRepository.findAll();
	}

	public Item getItem(String id) {
		
		//return itemList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return itemRepository.findOne(id);
	}

	public void addItem(Item item) {
		//itemList.add(item);
		itemRepository.save(item);
	}

	public void updateItem(Item item, String id) {
		/*
		 * for(int i=0;i<itemList.size();i++) { Item a = itemList.get(i);
		 * 
		 * if(a.getId().equals(id)) { itemList.set(i,item); return; } }
		 */
		itemRepository.save(item);
		
	}

	public void deleteItem(String id) {
		itemRepository.delete(id);
	}

}
