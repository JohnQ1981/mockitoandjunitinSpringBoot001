package com.in28002.junit.hamcrest.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class HamcrestMatchersTest {

//	@Test
//	void hamcrestTest() {
//		List<Integer> numbers = new  ArrayList<>();
//		numbers.add(15);
//		numbers.add(25);
//		numbers.add(45);
//		assertThat(numbers,hasSize(3));
//		assertThat(numbers, hasItems(15,45));
//		assertThat(numbers, everyItem(greaterThan(10)));
//		assertThat(numbers, everyItem(lessThan(100)));
//		
//		assertThat("", isEmptyString());
//		assertThat("ABCDE", containsString("BCD"));
//		assertThat("ABCDE", startsWith("ABCD"));
//		assertThat("ABCDE", endsWith("CDE"));
//		
//	}
	
	@Test
	void assertJTest() {
		List<Integer> numbers = new  ArrayList<>();
		numbers.add(15);
		numbers.add(25);
		numbers.add(45);
		assertThat(numbers)
		.hasSize(3)
		.contains(15,25)
		.allMatch(t-> t>10).allMatch(t-> t<100);
		
		assertThat("").isEmpty();
		assertThat("ABCDE")
		.contains("CD")
		.startsWith("ABC")
		.endsWith("DE");
		
		
		
	}

	

}
