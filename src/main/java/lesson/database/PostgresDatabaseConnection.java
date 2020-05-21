package lesson.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class PostgresDatabaseConnection {

    private static PostgresDatabaseConnection instance;

    private Connection connection;

    private Properties dbProperties;

    private PostgresDatabaseConnection() {
        dbProperties = new Properties();
        try {
            dbProperties.load(this.getClass().getClassLoader().getResourceAsStream("database/db.properties"));
        } catch (IOException e) {
            System.err.println("Read properties file error");
            e.printStackTrace();
        }
    }

    private void createConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("PostgresSQL JDBCDriver is not found. Include it in your classpath");
            e.printStackTrace();
            return;
        }

        try {
            connection = DriverManager.getConnection(dbProperties.getProperty("postgres.url"),
                    dbProperties.getProperty("postgres.username"), dbProperties.getProperty("postgres.password"));
        } catch (SQLException throwables) {
            System.err.println("Connection failed");
            throw new RuntimeException("Connection failed", throwables);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static PostgresDatabaseConnection getInstance() {
        if (instance == null) {
            instance = new PostgresDatabaseConnection();
            instance.createConnection();
        }
        return instance;
    }
}
