package com.portal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	public static final Database instance = new Database();

	private Database() {
		try {
			Class.forName("com.mysql.jdbc.Driver");	    //preload driver
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/celtra?autoReconnect=true", "root", "sitart5");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public boolean checkUserHash(final String user, final String hashedPassword) {
		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = null;
		String password = null;
		try {
			final String sql = "SELECT password FROM users WHERE name = ? LIMIT 0, 1";
			connection = Database.instance.getConnection();
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, user);
			rs = statement.executeQuery();
			while (rs.next()) { 
				password = getString(rs.getString("id"));
			}
			if (null!=password&&!password.isEmpty()) {
				String hashed = Utils.getMd5sum(password);
				return hashed.equalsIgnoreCase(hashedPassword);
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
		return false;
	}

	public boolean checkUser(final String user, final String password) {
		boolean isValid = true;
		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			final String sql = "SELECT * FROM users WHERE name = ? and password = ? LIMIT 0, 1";
			connection = Database.instance.getConnection();
			statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			statement.setString(1, user);
			statement.setString(2, password);
			rs = statement.executeQuery();
			if (!rs.next()) {
				isValid = false;
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

		return isValid;
	}

	public String getUserDetails() {
        final StringBuilder output = new StringBuilder();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            final String sql = "SELECT id,name FROM users";
            connection = Database.instance.getConnection();
            statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery();
            output.append("[");
            while (rs.next()) { // the rest if any
            	output.append("{");
                output.append("\"id\":\"");
                output.append(getString(rs.getString("id")));
                output.append("\",");
                output.append("\"name\":\"");
                output.append(getString(rs.getString("name")));
                output.append("\"");
                output.append("}");
                if (!rs.isLast()) {
                	output.append(",");
                }
            }
            output.append("]");
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

        return output.toString();
    }
	
    private String getString(String fromString) {
        return null==fromString || fromString.isEmpty() ? "" : fromString;
    }
	
    
}
