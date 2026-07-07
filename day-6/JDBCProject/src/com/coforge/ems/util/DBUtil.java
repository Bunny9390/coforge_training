package com.coforge.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// This class creates and returns a database connection.
public class DBUtil {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(ApplicationProperties.JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new SQLException(ApplicationProperties.DATABASE_CONNECTION_FAILED, e);
        }

        createDatabaseIfNotExists();

        Connection connection = DriverManager.getConnection(
                EMSConstants.DATABASE_URL,
                EMSConstants.USERNAME,
                EMSConstants.PASSWORD
        );

        createTableIfNotExists(connection);
        return connection;
    }

    private static void createDatabaseIfNotExists() throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                ApplicationProperties.DATABASE_BASE_URL,
                EMSConstants.USERNAME,
                EMSConstants.PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(ApplicationProperties.CREATE_DATABASE_SQL)) {
            preparedStatement.executeUpdate();
        }
    }

    private static void createTableIfNotExists(Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(EMSConstants.CREATE_TABLE_QUERY)) {
            preparedStatement.executeUpdate();
        }
    }
}
