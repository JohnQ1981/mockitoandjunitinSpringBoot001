package com.in28002.junit.junit002;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;

class ListMockTest {

	List<String> mockList = mock(List.class);
	@Test
	void size_basic() {
		//List mock = mock(List.class);
		when(mockList.size()).thenReturn(5);
		assertEquals(5,mockList.size());
	}
	
	@Test
	void returnDifferentValues() {
		
		when(mockList.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mockList.size());
		assertEquals(10,mockList.size());
	}
	@Test
	void returnWithParameters() {
		when(mockList.get(0)).thenReturn("John");
		assertEquals("John", mockList.get(0));
		assertEquals(null, mockList.get(1));
	}
	
	@Test
	void returnWithGenericParameters() {
		when(mockList.get(anyInt())).thenReturn("John");
		assertEquals("John", mockList.get(0));
		assertEquals("John", mockList.get(1));
	}
	@Test
	void verificationBasics() {
		//SystemUnderTest
		String value =  mockList.get(0);
		String value1 =  mockList.get(1);
		//Verify
		verify(mockList).get(0);
		verify(mockList, atLeast(1)).get(anyInt());
		verify(mockList,times(2)).get(anyInt());
		verify(mockList, atMost(2)).get(anyInt());
		verify(mockList, atLeastOnce()).get(anyInt());
		verify(mockList, never()).get(2);
	}
	@Test
	void argumentCapturing() {
		//SUT
		mockList.add("Hello");
		//Verify
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mockList).add(captor.capture());
		assertEquals("Hello",captor.getValue());
		
	}
	
	@Test
	void multipleArgumentCapturing() {
		//SUT
		mockList.add("Hello");
		mockList.add("World");
		//Verify
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mockList, times(2)).add(captor.capture());
		List<String> allValues=captor.getAllValues();
		assertEquals("Hello",allValues.get(0));
		assertEquals("World",allValues.get(1));
		
	}
	@Test
	void mocking() {
		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		System.out.println(arrayListMock.add("Test1"));
		System.out.println(arrayListMock.add("Test2"));
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());
		
	}
	
	@Test
	void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		System.out.println(arrayListSpy.add("Test0"));
		System.out.println(arrayListSpy.get(0));//Test0
		System.out.println(arrayListSpy.size());//1
		System.out.println(arrayListSpy.add("Test1"));
		System.out.println(arrayListSpy.add("Test2"));
		System.out.println(arrayListSpy.size());//3
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5
		
		System.out.println(arrayListSpy.add("Test3"));
		System.out.println(arrayListSpy.size());//5
		
		verify(arrayListSpy).add("Test3");
		
	}
}
