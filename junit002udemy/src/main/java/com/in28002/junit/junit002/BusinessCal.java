package com.in28002.junit.junit002;

import java.util.Arrays;
import java.util.OptionalInt;

import com.in28002.junit.junit002.dataserver.DataService;

public class BusinessCal {
	
	private DataService dataService;
	
	public int calculateSum(int[] data) {
		int sum=0;
		for(int w: data) {
			sum=sum+w;
		}
		return sum;
	}
	
	public int calculateSumFuntionalProgramming(int[] data) {
		//1,2,3,4=> 1+2+3+4+5
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
	}
	
	public int calculateSumDataService() {
		int sum=0;
		int[] data = dataService.retrieveAllData();
		for(int w: data) {
			sum=sum+w;
		}
		return sum;
	}
	
	public int calculateSumDataServiceWithFuntinalProgramming() {
		return   Arrays.stream(dataService.retrieveAllData()).reduce(Integer::sum).orElse(0);
		
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

}
