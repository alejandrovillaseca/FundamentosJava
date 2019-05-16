package com.aledev.amazon.model;

import java.util.Date;
/**
 * <h1>Film</h1>
 * Es una clase padre abstracta
 * <p>
 * Contiene método abstracto {@code Films} :D
 * @author s5098547
 * @version 1.0
 * 
 */
public abstract class Film {
	public String title;
	public String genre;
	public String creator;
	public int duration;
	public short year;
	public boolean viewed;
	
	public Film(String title, String genre, String creator, int duration) {
		super();
		this.title = title;
		this.genre = genre;
		this.creator = creator;
		this.duration = duration;
	}
	public Film() {};
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public int getDuration() {
 		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public String isViewed() {
		if(this.viewed)
			return "Si";
		else
			return "No";
	}
	public boolean getIsViewed() {
		return this.viewed;
	}
	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}
	/**
	 * Es un m�todo abstracto obligatorio de implementar
	 */
	public abstract void view();
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		
	}
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean getMovieViewed() {
		return true;
	}
}
