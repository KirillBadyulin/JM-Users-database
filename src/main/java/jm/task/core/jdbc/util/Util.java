package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/mysql";
    private static final String username = "root";
    private static final String password = "Overcome";
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, username, password);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database");
        }
    }

    public static boolean close() {
        try {

            if (connection != null) {
                connection.close();
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Couldn't close the connection. " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
