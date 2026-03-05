package com.resume.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/resume_analyzer";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Rakshi@2004";   // change if needed

    // Private constructor to prevent object creation
    private ConnectionFactory() {}

    // Static method to get database connection
    public static Connection getConnection() {

        Connection connection = null;

        try {
            // Load MySQL Driver (optional for newer versions but good practice)
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }

        return connection;
    }
}