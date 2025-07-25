package com.subject;

/* VO(Value Object)클래스는 데이터를 담는 컨테이너 역할을 하는 클래스로 데이터 전달을 목적으로 생성한다.
 * VO클래스는 어플리케이션 구조에서 각 단계의 입출력 정보를 전달하는 역할을 수행하며,
 * 필드, setter(설정자)와 getter(접근자)로 구성된다. toString() 메서드는 필드의 값을 확인하기 위해 사용한다.*/

public class SubjectVO {
	private int no;     //번호
	private String subjectNumber;
	private String subjectName;
	
	public SubjectVO() {
		
	}
	public SubjectVO(int no, String subjectNumber, String subjectName) {
		super();
		this.no = no;
		this.subjectNumber = subjectNumber;
		this.subjectName = subjectName;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubjectNumber() {
		return subjectNumber;
	}
	public void setSubjectNumber(String subjectNumber) {
		this.subjectNumber = subjectNumber;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	@Override
	public String toString() {
		return "SubjectVO [no=" + no + ", subjectNumber=" + subjectNumber + ", subjectName=" + subjectName +"]";
	}
}
