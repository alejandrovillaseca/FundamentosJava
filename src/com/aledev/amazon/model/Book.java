package com.aledev.amazon.model;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publication implements IVisualizable{
	
	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;

	public Book(String title, Date edititionDate, String editorial, String[] authors) {
		super(title, edititionDate, editorial, authors);
		// TODO Auto-generated constructor stub
		setAuthors(authors);
	}
	
	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isReaded() {
		return readed;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}

	public int getTimeReaded() {
		return timeReaded;
	}

	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}

	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if(dateF.getSeconds() > dateI.getSeconds())
			setTimeReaded(dateF.getSeconds() - dateI.getSeconds());
		else {
			setTimeReaded(0);
		}
		
	}
	
	public static ArrayList<Book> makeBookList() {
		ArrayList<Book> books = new ArrayList<Book>();
		String[] authors = new String[3];
		for (int i = 0; i < 3; i++) {
			authors[i] = "author "+i;
		}
		for (int i = 1; i <= 5; i++) {
			books.add(new Book("Book " + i, new Date(), "editorial " + i, authors));
		}
		
		return books;
	}
	
	public void view() {
		setReaded(true);
		Date dateI = startToSee(new Date());
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("..........");
		}
		
		//Termine de verla
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Leíste: " + toString());
		System.out.println("Por: " + getTimeReaded() + " milisegundos");
	}
	
}
