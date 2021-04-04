package com.in28002.junit.junit002.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28002.junit.junit002.model.Item;
import com.in28002.junit.junit002.repo.ItemRepo;
@Service
public class ItemBService {

	@Autowired
	private ItemRepo itemRepo;
	
	
	public Item retrieveItem() {
		
		return new Item(1,"Ball",10,100);
	}
	
	public List<Item> retrieveAll(){
		List<Item> items = itemRepo.findAll();
		for(Item w: items) {
			w.setValue(w.getPrice()*w.getQuantity());
		}
		return items;
	}
	

}
