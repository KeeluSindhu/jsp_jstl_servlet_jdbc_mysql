package DBconnections;

import java.sql.Connection;
import java.sql.DriverManager;

public class zomatoDBconnections {
	private static String driver="com.mysql.cj.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/zomato";
	private static String username="root";
	private static String password="root";
	private static Connection conn;
	public static Connection getconnection() {
	
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	

}
