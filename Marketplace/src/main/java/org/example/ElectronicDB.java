package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ElectronicDB {
    private final String HOST = "jdbc:mysql://localhost:3306/db_electronics";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private Connection connection;

    //object that connects project to database
    public ElectronicDB() {
        try {
            connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}
