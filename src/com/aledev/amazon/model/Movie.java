package com.aledev.amazon.model;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.aledev.amazon.dao.MovieDAO;
/**
 * Movie hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 * 
 * @author s5098547
 *
 */
public class Movie extends Film implements IVisualizable, MovieDAO{
	public int id;
	public int timeViewed;
	
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setYear(year);
	}
	public Movie() {};

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
			Movie movie = new Movie();
			return movie.read();
			
		} catch (Exception e) {
			return null;
		}
	}
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
		Movie movie = new Movie();
		try {
			movie.setMovieViewed(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date dateI = startToSee(new Date());
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("..........");
		}		
		//Terminé de verla
		stopToSee(dateI, new Date());
		System.out.println("Viste la película " + title + " y durï¿½ " + timeViewed + " milisegundos");
	}
	@Override
	public boolean getMovieViewed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n :: MOVIE ::" + 
				"\n Title: " + getTitle() +
				"\n Genero: " + getGenre() + 
				"\n Year: " + getYear() + 
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}
}
