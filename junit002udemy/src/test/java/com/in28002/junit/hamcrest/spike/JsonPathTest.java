package com.in28002.junit.hamcrest.spike;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

class JsonPathTest {

	@Test
	void jsonPathTest() {
		String responseFromService= "["
				+ "{\"id\":1001, \"name\":\"Pencil\",\"quantity\":5},"
				+ "{\"id\":1002, \"name\":\"Pen\",\"quantity\":15},"
				+ "{\"id\":1003, \"name\":\"Eraser\",\"quantity\":25},"
				+ "{\"id\":1004, \"name\":\"Notebook\",\"quantity\":5}"
				+ ""
				+ "]";
		DocumentContext context = JsonPath.parse(responseFromService);
		int length= context.read("$.length()");
		assertThat(length).isEqualTo(4);
		List<Integer>ids=context.read("$..id");
		assertThat(ids).containsExactly(1001,1002,1003,1004);
		System.out.println(ids.toString());
		
		List<String>names=context.read("$..name");
		System.out.println(names.toString());
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:2]").toString());
		System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
		System.out.println(context.read("$.[?(@.quantity==5)]").toString());
		
		
	}

}
