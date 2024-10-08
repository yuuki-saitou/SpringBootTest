package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Memo {

	private static int idCounter = 0;

	private int id;
	private String title;
	private String message;
	private LocalDateTime createdAt;
	private boolean completed;

	public Memo(String title, String message) {

		this.id = ++idCounter;
		this.title = title;
		this.message = message;
		this.createdAt = LocalDateTime.now();
		this.completed = false;

	}

}
