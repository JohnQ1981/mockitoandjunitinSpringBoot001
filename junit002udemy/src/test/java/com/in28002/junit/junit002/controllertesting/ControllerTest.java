package com.in28002.junit.junit002.controllertesting;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.in28002.junit.junit002.controller.Controller;
@ExtendWith(SpringExtension.class)
@WebMvcTest(Controller.class)
class ControllerTest {

	
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void helloWorld_basic() throws Exception {
		//call GET request/"hello"/
		RequestBuilder request= MockMvcRequestBuilders
				.get("/hello")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result= mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World"))
				.andReturn();
		
		// verify "Hello World
		assertEquals("Hello World", result.getResponse().getContentAsString());
		
		
	}

}
