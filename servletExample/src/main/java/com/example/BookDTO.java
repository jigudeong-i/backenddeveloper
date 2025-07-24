package com.example;

public class BookDTO {    // DTO(Data Transfer Object)
	private String title;
	private String author;
	private String publisher;
	
	public BookDTO() {
		super();
	}

	public BookDTO(String title, String author, String publisher) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {   // 여기서 toString은 사용자에게 보여주는 용도x. 필드가 값을 제대로 가지고 있는지 확인할 용도o 
		return "BookDTO [title=" + title + ", author=" + author + ", publisher=" + publisher + "]";
	}
}



