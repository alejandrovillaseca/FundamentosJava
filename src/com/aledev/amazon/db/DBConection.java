package com.aledev.amazon.db;
import java.sql.Connection;
import java.sql.DriverManager;
import static com.aledev.amazon.db.DataBase.*;
public interface DBConection {
	
	default Connection connectDB(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL + DBNAME	, USER, PASSWORD);
			if(conn != null) {
				System.out.println("Se estableció la conexion a la db :)");
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			return conn;
		}
	}

}
