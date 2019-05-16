package com.aledev.amazon;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.aledev.amazon.model.Book;
import com.aledev.amazon.model.Chapter;
import com.aledev.amazon.model.Movie;
import com.aledev.amazon.model.Serie;
import com.aledev.amazon.util.AmazonUtil;

/**
 * <h1>Amazon Viewer</h1> AmazonViewer es un programa que permite visualizar
 * películas, series, con sus respectivos capítulos, Books y Magazines. Te
 * permite generar reportes generales con fecha del día
 * <p>
 * Existen reglas en que todos los elementos pueden ser vistos.
 * 
 * @author s5098547
 * @version 1.0
 * @since 2019
 * 
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Film film = new Movie("", "", "", 1, (short)199);
		
		showMenu();

	}

	public static void showMenu() {
		int exit = 0;
		do {
			System.out.println("Bienvenidos amazon Viewer");
			System.err.println("");
			System.out.println("Selecciona el número de la película");
			System.out.println("1. Movies");
			System.out.println("2. Series");
			System.out.println("3. Books");
			System.out.println("4. Magazines");
			System.out.println("5. Report");
			System.out.println("6. Report Today");
			System.out.println("0. Exit");
		} while (exit != 0);

		// Book book = new Book("",new Date(), "", new String[0], "", true, 1);
		// int _id = book.getId();

		// Leer la respuesta del usuario
		Scanner sc = new Scanner(System.in);
		int response = Integer.valueOf(sc.nextLine());

		switch (response) {
		case 0:
			System.out.println("Saliendo...");
			System.exit(1);
			break;
		case 1:
			showMovies();
			break;
		case 2:
			showSeries();
			break;
		case 3:
			showBooks();
			break;
		case 4:
			showMagazine();
			break;
		case 5:
			Report();
			break;
		case 6:
			Report(new Date());
			break;
		default:
			System.out.println("Debes seleccionar una opciï¿½n vï¿½lida...");
			break;
		}
		showMovies();
	}

	public static void showChapters(List<Chapter> chaptersOfSerieSelected) {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: CHAPTERS ::");
			System.out.println();
			
			
			for (int i = 0; i < chaptersOfSerieSelected.size(); i++) { //1. Chapter 1
				System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: " + chaptersOfSerieSelected.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, chaptersOfSerieSelected.size());
			
			if(response == 0) {
				exit = 0;
			}
			
			
			if(response > 0) {
				Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
				chapterSelected.view();
			}
		}while(exit !=0);
	}

	static ArrayList<Serie> series = Serie.makeSeriesList();

	public static void showSeries() {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: SERIES ::");
			System.out.println();

			for (int i = 0; i < series.size(); i++) { // 1. Serie 1
				System.out.println(i + 1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
			}

			System.out.println("0. Regresar al Menu");
			System.out.println();

			// Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, series.size());

			if (response == 0) {
				exit = 0;
				showMenu();
			}

			if (response > 0) {
				showChapters(series.get(response - 1).getChapters());
			}

		} while (exit != 0);
	}

	static ArrayList<Book> books = Book.makeBookList();

	public static void showBooks() {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();

			for (int i = 0; i < books.size(); i++) { // 1. Book 1
				System.out.println(i + 1 + ". " + books.get(i).getTitle() + " Leído: " + books.get(i).isReaded());
			}

			System.out.println("0. Regresar al Menu");
			System.out.println();

			// Leer Respuesta usuario
			int response = AmazonUtil.validateUserResponseMenu(0, books.size());

			if (response == 0) {
				exit = 0;
				showMenu();
			}

			if (response > 0) {
				Book bookSelected = books.get(response - 1);
				bookSelected.view();
			}

		} while (exit != 0);
	}

	public static void showMagazine() {
		int exit = 1;
		do {
			System.out.println("::MOVIES::");
			System.out.println("");
		} while (exit != 0);
	}

	public static void Report(Date fecha) {
		com.aledev.makereport.Report report = new com.aledev.makereport.Report();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = df.format(fecha);

		String content = "";
		for (Movie movie : movies) {
			if (movie.getIsViewed())
				content += movie.getTitle() + "\n"; // se puede crear un mï¿½todo tostring en movie para que imprima
													// todo lo que queremos.
		}

		report.setNameFile("reporteNew" + dateString);
		report.setExtension("txt");
		report.setContent(content);
		report.setTitle(":: VISTOS ::");
		report.makeReport();
	}

	public static void Report() {
		com.aledev.makereport.Report report = new com.aledev.makereport.Report();
		report.setNameFile("reporte");
		report.setTitle(":: VISTOS ::");
		report.setExtension("txt");
		String content = "";
		for (Movie movie : movies) {
			if (movie.getIsViewed())
				content += movie.toString() + "\n"; // se puede crear un mï¿½todo tostring en movie para que imprima
													// todo lo que queremos.
		}
		for (Serie serie : series) {
			List<Chapter> chapters = serie.getChapters();
			for (Chapter chapter : chapters) {
				if (chapter.getIsViewed()) {
					content += chapter.toString() + "\n";
					
				}
			}	
		}
		
		
		for (Book book : books) {
			if (book.isReaded()) {
				content += book.toString() + "\n";
				
			}
		}
		report.setContent(content);
		report.makeReport();
	}

	static List<Movie> movies = Movie.makeMovies(); // importante para que no se vuelva a inicializar... y sea
													// persistente.

	public static void showMovies() {
		int exit = 1;
		// movies = Movie.makeMovies();
		do {
			System.out.println();
			System.out.println(":: MOVIES ::");
			System.out.println();

			for (Movie movie : movies) {
				System.out.println(movie.title + " Visto: " + movie.isViewed());
			}

			System.out.println("0. Regresar al Menu");
			System.out.println("");

			// Leer respuesta del usuario
			Scanner sc = new Scanner(System.in);
			int response = Integer.valueOf(sc.nextLine());

			if (response == 0)
				showMenu();

			if (response > 0) {
				Movie movieSelected = movies.get(response - 1);
				movieSelected.view();
			}

		} while (exit != 0);

	}

}
