package com.in28002.junit.junit002.controllertesting;


import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import com.in28002.junit.junit002.controller.ItemController;
import com.in28002.junit.junit002.model.Item;
import com.in28002.junit.junit002.service.ItemBService;
@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {

	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBService businessService;
	
	@Test
	void item_basic() throws Exception {
		//call GET request/"hello"/
		RequestBuilder request= MockMvcRequestBuilders
				.get("/item")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result= mockMvc.perform(request)
				.andExpect(status().isOk())
				//.andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();
		
		// verify "Hello World
		//assertEquals("Hello World", result.getResponse().getContentAsString());
		
		
	}
	
	@Test
	void item_frombusiness() throws Exception {
		when(businessService.retrieveItem()).thenReturn(new Item(2,"Item2",10,10));
		//call GET request/"hello"/
		RequestBuilder request= MockMvcRequestBuilders
				.get("/itemb")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result= mockMvc.perform(request)
				.andExpect(status().isOk())
				//.andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andExpect(content().json("{id:2,name:Item2,price:10,quantity:10}"))
				.andReturn();
	}
	
	@Test
	void item_retrieveAllTest() throws Exception {
		when(businessService.retrieveAll()).thenReturn(
				Arrays.asList(new Item(2,"Item2",10,10),new Item(3,"Item3",15,10))
				
				);
		//call GET request/"hello"/
		RequestBuilder request= MockMvcRequestBuilders
				.get("/allitems")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result= mockMvc.perform(request)
				.andExpect(status().isOk())
				//.andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andExpect(content().json("[{id:3,name:Item3,price:15,quantity:10},{id:2,name:Item2,price:10,quantity:10}]"))
				.andReturn();
	}
	
	

}
