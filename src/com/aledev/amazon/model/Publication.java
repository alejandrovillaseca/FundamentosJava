package com.aledev.amazon.model;

import java.util.Date;

public class Publication {

	public String title;
	public Date editionDate;
	public String editorial;
	public String[] authors;
	public int id;
	
	public Publication(String title, Date editionDate, String editorial, String[] authors) {
		super();
		this.title = title;
		this.editionDate = editionDate;
		this.editorial = editorial;
		this.authors = authors;
	}
	public int getId() {
		return this.id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getEditionDate() {
		return editionDate;
	}
	public void setEditionDate(Date editionDate) {
		this.editionDate = editionDate;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return null;
	}
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		
	}
	
	
}
