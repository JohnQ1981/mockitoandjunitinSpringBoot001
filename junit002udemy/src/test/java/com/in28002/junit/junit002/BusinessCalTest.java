package com.in28002.junit.junit002;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.in28002.junit.junit002.dataserver.DataService;

class BusinessCalTest {

	@Autowired
	private DataService dataService;
	BusinessCal business= new BusinessCal();
		
	@Test
	void businessCalclTest() {
		
		int actualResult= business.calculateSum(new int[] {1,2,3});
		int expectedResult=6;
		assertEquals(expectedResult, actualResult);
				
	}
	
	@Test
	void businessCalclTest_Empty() {
		
		int actualResult= business.calculateSum(new int[] {});
		int expectedResult=0;
		assertEquals(expectedResult, actualResult);
				
	}
	@Test
	void businessCalclTest_OneValue() {
		
		int actualResult= business.calculateSum(new int[] {1});
		int expectedResult=1;
		assertEquals(expectedResult, actualResult);
				
	}
	

}
