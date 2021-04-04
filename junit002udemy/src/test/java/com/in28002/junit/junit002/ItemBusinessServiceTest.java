package com.in28002.junit.junit002;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.in28002.junit.junit002.model.Item;
import com.in28002.junit.junit002.repo.ItemRepo;
import com.in28002.junit.junit002.service.ItemBService;


@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
	
	@InjectMocks
	private ItemBService business;//= new BusinessCal();
	@Mock
	private ItemRepo repo;// = mock(DataService.class);
	
//	@BeforeEach
//	void beforeEach() {
//		business.setDataService(dataServiceMock);
//		System.out.println("This is beforeEach");
//	}

	@Test
	void retrieveAllTest() {		
		when(repo.findAll()).thenReturn(Arrays.asList(new Item(2,"Item2",10,10),new Item(3,"Item3",15,10)));			
		//assertEquals(7, business.calculateSumDataService());
		List<Item> items = business.retrieveAll();
		assertEquals(100,items.get(0).getValue());
		assertEquals(150,items.get(1).getValue());
				
	}
	
	
}
