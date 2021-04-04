package com.in28002.junit.junit002.controllertesting;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {
	
	String actualResponse= "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	void jsonAssertTestWithTrue() throws JSONException {
		String expectedResponse="{\"id\":1,\"name\":\"Ball\",\"price\" :10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	
	@Test
	void jsonAssertTestWithFalse() throws JSONException {
		String expectedResponse="{\"id\":1,\"name\":\"Ball\",\"price\" :10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	@Test
	void jsonAssertTestWithWithoutEscapeCharacters() throws JSONException {
		String expectedResponse="{id:1,name:Ball,price :10}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

}
