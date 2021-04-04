package com.in28002.junit.junit002.controllertesting;

import static org.mockito.Mockito.when;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.in28002.junit.junit002.repo.ItemRepo;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class ItemControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;
	@MockBean
	private ItemRepo itemRepo;

	@Test
	void contextLoads() throws JSONException {
		
		
		
		String response =this.restTemplate.getForObject("/allitems", String.class);
		JSONAssert.assertEquals("[{id:100},{id:101},{id:102},{id:103}]", response, false);
	}

}
