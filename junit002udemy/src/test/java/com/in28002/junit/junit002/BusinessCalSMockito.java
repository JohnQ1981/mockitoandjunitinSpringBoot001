package com.in28002.junit.junit002;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28002.junit.junit002.dataserver.DataService;

@ExtendWith(MockitoExtension.class)
class BusinessCalSMockito {
	
	@InjectMocks
	BusinessCal business;//= new BusinessCal();
	@Mock
	DataService dataServiceMock;// = mock(DataService.class);
	
//	@BeforeEach
//	void beforeEach() {
//		business.setDataService(dataServiceMock);
//		System.out.println("This is beforeEach");
//	}

	@Test
	void businessCalclTestMock() {		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,4});			
		assertEquals(7, business.calculateSumDataService());
		System.out.println("Test--1 "+business.calculateSumDataService());
				
	}
	
	@Test
	void businessCalclTest_Empty() {		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumDataService());
//		int actualResult= business.calculateSumDataService();
//		int expectedResult=0;
//		assertEquals(expectedResult, actualResult);
				
	}
	@Test
	void businessCalclTest_OneValue() {		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});	
		assertEquals(15, business.calculateSumDataService());
//		int actualResult= business.calculateSumDataService();
//		int expectedResult=15;
//		assertEquals(expectedResult, actualResult);
				
	}

}
