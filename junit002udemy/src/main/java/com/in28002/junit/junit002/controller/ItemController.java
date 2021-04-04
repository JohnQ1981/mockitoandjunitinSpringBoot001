package com.in28002.junit.junit002.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28002.junit.junit002.model.Item;
import com.in28002.junit.junit002.repo.ItemRepo;
import com.in28002.junit.junit002.service.ItemBService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemBService businessService;
	@GetMapping("/item")
	public Item item() {
		return new Item(1,"Ball",10,100);
	}
	@GetMapping("/itemb")
	public Item itemBService() {
		return businessService.retrieveItem();
	}
	@GetMapping("/allitems")
	public List<Item> findall(){
		return businessService.retrieveAll();
		
	}

}
