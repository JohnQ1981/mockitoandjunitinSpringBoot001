package com.in28002.junit.junit002;

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
	
	public int calculateSumDataService() {
		int sum=0;
		int[] data = dataService.retrieveAllData();
		for(int w: data) {
			sum=sum+w;
		}
		return sum;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

}
