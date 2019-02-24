package com.aledev.amazon.model;

import java.util.Date;

public class Magazine extends Publication{
	private int id;

	public Magazine(String title, Date editionDate, String editorial, String[] authors, int id) {
		super(title, editionDate, editorial, authors);
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "hola";
	}
	
}
