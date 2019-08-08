package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectData {
		
	public static Connection connect() {
		String url = "jdbc:mysql:// localhost:3306/us?serverTimezone=GMT%2B8";

		//String url = "jdbc:mysql:// localhost:3306/us?serverTimezone=GMT%2B8";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(Exception e) {}
		
		Connection con = null ;
		
		try {
			con = DriverManager.getConnection(url, "root", "000000");
		}catch(SQLException e) {
		}
		return con;
	}
}
