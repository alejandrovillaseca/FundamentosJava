package com.aledev.amazon.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Chapter extends Movie{
	
	
	private int id;
	private int sessionNumber;
	private Serie serie;
	
	public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber) {
		super(title, genre, creator, duration, year);
		// TODO Auto-generated constructor stub
		this.setSessionNumber(sessionNumber);
	}
	
	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}
	public static ArrayList<Chapter> makeChaptersList(Serie serie) {
		  ArrayList<Chapter> chapters = new ArrayList<>();
		  
		  for (int i = 1; i <= 5; i++) {
		    //chapters.add(new Chapter("Chapter " + i, "Genre " + i, "Creator " + i, 45 + i, (short) (2017 + i), i, serie));
		  }
		  
		  return chapters;
		}
	public int getId() {
		return id;
	}
	
	public Serie getSerie() {
		return serie;
	}
	
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		super.view();
		List<Chapter> chapters = getSerie().getChapters();
		int chapterViewedCounter = 0;
		for (Chapter chapter : chapters) {
			if (chapter.getIsViewed()) {
				chapterViewedCounter++;
			}
		}
		if(chapterViewedCounter == chapters.size()) {
			getSerie().setViewed(true);
		}
	}
	
}
