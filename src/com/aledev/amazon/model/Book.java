package com.aledev.amazon.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aledev.amazon.util.AmazonUtil;

public class Book extends Publication implements IVisualizable {

	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;
	private List<Page> pages;

	public Book(String title, Date edititionDate, String editorial, String[] authors, ArrayList<Page> pages) {
		super(title, edititionDate, editorial, authors);
		// TODO Auto-generated constructor stub
		setAuthors(authors);
		this.pages = pages;
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
		if (dateF.getSeconds() > dateI.getSeconds())
			setTimeReaded(dateF.getSeconds() - dateI.getSeconds());
		else {
			setTimeReaded(0);
		}

	}

	public static ArrayList<Book> makeBookList() {
		ArrayList<Book> books = new ArrayList<Book>();
		String[] authors = new String[3];
		for (int i = 0; i < 3; i++) {
			authors[i] = "author " + i;
		}
		
		ArrayList<Page> pages = new ArrayList();
		int pagina = 0;
		for (int i = 0; i < 3; i++) {
			pagina = i + 1;
			pages.add(new Book.Page(pagina, "El contenido de la página " + pagina));
		}
		
		for (int i = 1; i <= 5; i++) {
			books.add(new Book("Book " + i, new Date(), "editorial " + i, authors, pages));
		}

		return books;
	}

	public void view() {
		setReaded(true);
		Date dateI = startToSee(new Date());

		int i = 0;
		do {
			System.out.println(".........");
			System.out.println("Page " + getPages().get(i).getNumberPage());
			System.out.println(getPages().get(i).getContent());
			System.out.println(".........");

			if (i != 0) {
				System.out.println("1. Regrersar página");
			}
			System.out.println("2. Siguiente página");
			System.out.println("0. Cerrar libro");
			System.out.println();

			int response = AmazonUtil.validateUserResponseMenu(0, 2);
			if (response == 2) {
				i++;
			} else if (response == 1) {
				i--;
			} else if (response == 0) {
				// Salimos del libro
				break;
			}

		} while (i < getPages().size());

		// Termine de verla
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Leíste: " + toString());
		System.out.println("Por: " + getTimeReaded() + " milisegundos");
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}

	public static class Page {
		private int id;
		private int numberPage;
		private String content;

		public Page(int numberPage, String content) {
			super();
			this.numberPage = numberPage;
			this.content = content;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getNumberPage() {
			return numberPage;
		}

		public void setNumberPage(int numberPage) {
			this.numberPage = numberPage;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

	}

}
