package com.aledev.amazon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.aledev.amazon.db.DataBase.*;
import com.aledev.amazon.db.DBConection;
import com.aledev.amazon.model.Movie;

public interface MovieDAO extends DBConection{
	 default Movie setMovieViewed(Movie movie) throws SQLException {
		 try(Connection conn = connectDB()){
			 Statement st = conn.createStatement();
			 String query = "INSERT INTO " + TVIEWED + 
					 " ("+TVIEWED_IDMATERIAL+", "+TVIEWED_IDELEMENT+", "+TVIEWED_IDUSUARIO+")" + 
					 " VALUES("+ID_TMATERIALS[0]+", "+movie.getId()+", "+TUSER_IDUSUARIO+")";
			 
			 if (st.executeUpdate(query) > 0) {
				System.out.println("Se insertó y se marcó en visto");
			}
			 
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		 
		 return movie;
	 }

	 default ArrayList<Movie> read(){
		 ArrayList<Movie> movies = new ArrayList<>();
		 try(Connection conn = connectDB()) {
			 String query = "SELECT * FROM " + TMOVIE;
			 PreparedStatement ps = conn.prepareStatement(query);
			 ResultSet rs = ps.executeQuery();
			 while (rs.next()) {
					Movie movie = new Movie(
							rs.getString(TMOVIE_TITLE), 
							rs.getString(TMOVIE_GENRE), 
							rs.getString(TMOVIE_CREATOR), 
							Integer.valueOf(rs.getString(TMOVIE_DURATION)), 
							Short.valueOf(rs.getString(TMOVIE_YEAR)));
					
					movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
					movie.setViewed(getMovieViewed(ps, conn, 
							Integer.valueOf(rs.getString(TMOVIE_ID))));
					movies.add(movie);
					
				}
			 
			 //Testing Lambda
			 var a = movies.stream().filter(x -> x.creator == "").findFirst().get();
			 //Testing filter con predicates
			 Predicate<Movie> moviesViewed = s -> s.getIsViewed();
			 movies.stream().filter(moviesViewed);
			 
			 //Consumer: acciones de iteracion
			 Consumer<Movie> moviesEach = m -> {
				var test = m.getIsViewed();
				movies.stream().filter(mm -> test == mm.getIsViewed());
			 };
			 movies.stream().forEach(moviesEach);
			 
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return movies;
	 }
	 
	 private boolean getMovieViewed(PreparedStatement preparedStatement, Connection connection, int id_movie) {
			boolean viewed = false;
			String query = "SELECT * FROM " + TVIEWED +
					" WHERE " + TVIEWED_IDMATERIAL + "= ?"+ 
					" AND " + TVIEWED_IDELEMENT + "= ?" +
					" AND " + TVIEWED_IDUSUARIO + "= ?";
			ResultSet rs = null;
			
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, ID_TMATERIALS[0]);
				preparedStatement.setInt(2, id_movie);
				preparedStatement.setInt(3, TUSER_IDUSUARIO);
				
				rs = preparedStatement.executeQuery();
				viewed = rs.next();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
					
			return viewed;
		}
}
