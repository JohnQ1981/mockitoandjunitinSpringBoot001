package com.in28002.junit.junit002.testingdatalayer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.in28002.junit.junit002.model.Item;
import com.in28002.junit.junit002.repo.ItemRepo;
@DataJpaTest
class ItemRepoTest {

	@Autowired
	private ItemRepo itemRepo;
	@Test
	void testFinAll() {
		List<Item> items = itemRepo.findAll();
		assertEquals(4, items.size());
	}
	
	@Test
	void testFinbyId() {
		Optional<Item> items = itemRepo.findById(100);
		assertEquals(100, items.get().getId());
	}

}
