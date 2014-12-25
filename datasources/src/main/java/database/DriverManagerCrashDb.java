package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverManagerCrashDb {
	
	// singleton 
	
	public static final DriverManagerCrashDb instance = new DriverManagerCrashDb();

	// private 
	
	private DriverManagerCrashDb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");	   
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/information_schema?autoReconnect=true", "root", "jboss");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String get() {
		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = null;
		StringBuilder out = new StringBuilder();
		try {
			final String sql = "SELECT COMMENT FROM ENGINES ORDER BY RAND()";
			connection = DriverManagerCrashDb.instance.getConnection();
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery();
			while (rs.next()) { 
				out.append("<br>");
				out.append(rs.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return out.toString();
	}
    
}
