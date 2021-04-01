package com.in28002.junit.junit002;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import com.in28002.junit.junit002.dataserver.DataService;



class DataServiceStub implements DataService{
	public int[] retrieveAllData() {
		return new int[] {1,2,4};
	}
}

class DataServiceStub1 implements DataService{
	public int[] retrieveAllData() {
		return new int[] {};
	}
}
class DataServiceStub2 implements DataService{
	public int[] retrieveAllData() {
		return new int[] {5};
	}
}

class BusinessCalStub {

	@Test
	void businessCalclTest() {
		BusinessCal business= new BusinessCal();
		business.setDataService(new DataServiceStub());
		int actualResult= business.calculateSumDataService();
		int expectedResult=7;
		assertEquals(expectedResult, actualResult);
				
	}
	
	@Test
	void businessCalclTest_Empty() {
		BusinessCal business= new BusinessCal();
		business.setDataService(new DataServiceStub1());
		int actualResult= business.calculateSumDataService();
		int expectedResult=0;
		assertEquals(expectedResult, actualResult);
				
	}
	@Test
	void businessCalclTest_OneValue() {
		BusinessCal business= new BusinessCal();
		business.setDataService(new DataServiceStub2());
		int actualResult= business.calculateSumDataService();
		int expectedResult=5;
		assertEquals(expectedResult, actualResult);
				
	}

}
