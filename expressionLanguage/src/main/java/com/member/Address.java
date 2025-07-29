package com.member;

public class Address { // 클래스 구성요소 -> 필드/생성자/메서드
	private String city;
	private String zipcode;
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}