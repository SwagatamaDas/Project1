package com.dao;
 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
 
public class DBConnectionManager {
	private static Connection con = null;
 
    public static Connection getConnection() throws SQLException {
        try {
            if (con == null || con.isClosed()) {
                Properties properties = new Properties();
 
                // Load the properties file
                InputStream inputStream = DBConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");
                if (inputStream == null) {
                    throw new FileNotFoundException("Unable to locate database.properties file.");
                }
 
                properties.load(inputStream);
 
                String driverName = properties.getProperty("drivername");
                String url = properties.getProperty("url");
                String username = properties.getProperty("username");
                String password = properties.getProperty("password");
 
                // Load the JDBC driver
                Class.forName(driverName);
 
                // Establish the database connection
                con = DriverManager.getConnection(url, username, password);
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new SQLException("Failed to initialize database connection. " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while connecting to the database.", e);
        }
 
        return con;
    }
 
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}