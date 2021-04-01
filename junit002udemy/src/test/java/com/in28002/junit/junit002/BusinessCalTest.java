package com.in28002.junit.junit002;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BusinessCalTest {

	@Test
	void businessCalclTest() {
		BusinessCal business= new BusinessCal();
		int actualResult= business.calculateSum(new int[] {1,2,3});
		int expectedResult=6;
		assertEquals(expectedResult, actualResult);
				
	}
	
	@Test
	void businessCalclTest_Empty() {
		BusinessCal business= new BusinessCal();
		int actualResult= business.calculateSum(new int[] {});
		int expectedResult=0;
		assertEquals(expectedResult, actualResult);
				
	}
	@Test
	void businessCalclTest_OneValue() {
		BusinessCal business= new BusinessCal();
		int actualResult= business.calculateSum(new int[] {1});
		int expectedResult=1;
		assertEquals(expectedResult, actualResult);
				
	}

}
