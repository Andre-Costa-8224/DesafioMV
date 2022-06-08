package desafiomv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3305/mvdb";
	
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			System.out.println("Conectado");
//			PreparedStatement ps = conn.prepareStatement("DELIMITER $$\ncreate procedure verclientes\nBEGIN\nEND $$\nDELIMITER;");
//			ps.execute();
//			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
