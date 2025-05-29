package main.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    private static Connection connection;
    private ConnectionFactory(Connection connection) {}

    private static Connection initConnection() {
        String url = "jdbc:postgresql://localhost:5433/database_test";
        String user = "ego";
        String password = "admin";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = initConnection();
            return connection;
        } else {
            return connection;
        }
    }
}
