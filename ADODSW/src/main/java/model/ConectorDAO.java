package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorDAO {
		
		private static Connection con = null;	
		public static Connection conecta() {
			final String URL = "jdbc:mysql://localhost:3306/ado1";
			final String USER = "root";
			final String PASS = "root";
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(URL,USER,PASS);
		
		}catch(SQLException e) {
			System.out.println("CONEXÃO FAILL: "+e.getMessage());
		}
		return con;
}
}
