package com.grade;

public class StudentGrade {
	private double average;
	
	public void setAverage(double ...num) { // ... -> 가변길이 인자. 원하는 값 명시.  
		if(num == null) return;
		double sum = 0;
		for(int i =0 ; i <num.length; i++) {
			sum += num[i];
		}
		average = sum / (int)num.length;
	}

	public double getAverage() {
		return average;
	}
}