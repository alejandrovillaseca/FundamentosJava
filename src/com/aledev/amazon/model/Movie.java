package com.aledev.amazon.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Movie hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 * 
 * @author s5098547
 *
 */
public class Movie extends Film implements IVisualizable{
	public int id;
	public int timeViewed;
	
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}

	public void showData() {
		System.out.println("Title: " + this.title);
		System.out.println("Genero: " + this.genre);
		System.out.println("Año: " + this.year);
	}

	public int getId() {
		return this.id;
	}

	public int getTimeReaded() {
		return timeViewed;
	}

	public void setTimeReaded(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date startToSee(Date dateI) {
		// TODO Auto-generated method stub
		return dateI;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopToSee(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if(dateF.getTime() > dateI.getTime())
			setTimeReaded((int)dateF.getTime() - (int)dateI.getTime());
		else {
			setTimeReaded(0);
		}
	}
	
	public static List<Movie> makeMovies(){
		try {
			List<Movie> movies = new ArrayList<Movie>();
			for (int i = 1; i < 10; i++) {
				movies.add(new Movie("Movie" + i, "Genero" + i, "Creador" + i, 120+i, (short)(2017+i)));
			}
			return movies;
			
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
		Date dateI = startToSee(new Date());
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("..........");
		}		
		//Terminé de verla
		stopToSee(dateI, new Date());
		System.out.println("Viste la pelï¿½cula " + title + " y durï¿½ " + timeViewed + " milisegundos");
	}
	
}
