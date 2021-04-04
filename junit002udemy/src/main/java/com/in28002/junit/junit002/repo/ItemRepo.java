package com.in28002.junit.junit002.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28002.junit.junit002.model.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
