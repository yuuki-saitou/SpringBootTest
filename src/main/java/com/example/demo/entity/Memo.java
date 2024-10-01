package com.example.demo.entity;

public class Memo {
	
	private int id;
	private String title;
	private String message;
	
	private static int idCounter = 1;
	
	public Memo(String title, String message){
		this.title = title;
		this.message = message;
		this.id = idCounter++;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setMessage(String message) {
		this.message= message;
	}

}
