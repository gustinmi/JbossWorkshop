package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NavadnaBaza {
	
	// singleton 
	
	public static final NavadnaBaza instance = new NavadnaBaza();

	// private 
	
	private NavadnaBaza() {
		try {
			Class.forName("com.mysql.jdbc.Driver");	   
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		try {
			//													  jndi sintaksa
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
			final String sql = "SELECT COMMENT FROM ENGINES";
			connection = NavadnaBaza.instance.getConnection();
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery();
			while (rs.next()) { 
				out.append("\n");
				out.append(rs.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					;
				}
				rs = null;
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					;
				}
				statement = null;
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					;
				}
				connection = null;
			}
		}
		return out.toString();
	}
    
}
