package com.aledev.amazon.model;

import java.util.List;

public class Serie extends Film{
	private int id;
	private int sessionQuantity;
	private List<Chapter> chapter;

	public Serie(String title, String genre, String creator, int duration, int sessionQuantity) {
		super(title, genre, creator, duration);
		this.sessionQuantity = sessionQuantity;
	}

	public int getId() {
		return id;
	}
	
	public int getSessionQuantity() {
		return sessionQuantity;
	}

	public void setSessionQuantity(int sessionQuantity) {
		this.sessionQuantity = sessionQuantity;
	}

	public Serie(String title, String genre, String creator, int duration, List<Chapter> chapter) {
		super(title, genre, creator, duration);
		this.chapter = chapter;
	}
	
}
