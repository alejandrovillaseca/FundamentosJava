package com.aledev.amazon.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Serie extends Film {
	private int id;
	private int sessionQuantity;
	private List<Chapter> chapters;

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
		this.chapters = chapter;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
//	public static ArrayList<Serie> makeSeriesList() {
//		ArrayList<Serie> series = new ArrayList<>();
//
//		for (int i = 1; i <= 5; i++) {
//			Serie serie = new Serie("Serie " + i, "Genre " + i, "Creator " + i, 1200 + i, 5 + i);
//			serie.setChapters(Chapter.makeChaptersList(serie));
//			series.add(serie);
//		}
//
//		return series;
//	}
	
	
}
