package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }


//    private final Connection connection = Util.connection;
//
//    public UserDaoJDBCImpl() {
//    }
//
//    public void createUsersTable() {
//        String createTable = "CREATE TABLE IF NOT EXISTS users (id int AUTO_INCREMENT PRIMARY KEY, name text, lastname text, age int)";
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(createTable);
//            connection.commit();
//        } catch (SQLException e) {
//            System.out.println("Couldn't create users table:" + e.getMessage());
//            e.printStackTrace();
//            try {
//                connection.rollback();
//            } catch (SQLException e2) {
//                System.out.println("Couldn't perform rollback");
//            }
//        }
//    }
//
//    public void dropUsersTable() {
//        String dropTable = "DROP TABLE IF EXISTS users";
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(dropTable);
//            connection.commit();
//        } catch (SQLException e) {
//            System.out.println("Couldn't delete users table:" + e.getMessage());
//            e.printStackTrace();
//            try {
//                connection.rollback();
//            } catch (SQLException e2) {
//                System.out.println("Couldn't perform rollback");
//            }
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String addUser = "INSERT INTO users (name, lastName, age) VALUES ('" + name + "', '" + lastName + "', " + age + ")";
//
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(addUser);
//            connection.commit();
//        } catch (SQLException e) {
//            System.out.println("Couldn't save user:" + e.getMessage());
//            e.printStackTrace();
//            try {
//                connection.rollback();
//            } catch (SQLException e2) {
//                System.out.println("Couldn't perform rollback");
//            }
//        }
//    }
//
//    public void removeUserById(long id) {
//        String removeUser = "DELETE FROM users WHERE id = " + id + "";
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(removeUser);
//            connection.commit();
//        } catch (SQLException e) {
//            System.out.println("Couldn't revome user:" + e.getMessage());
//            e.printStackTrace();
//            try {
//                connection.rollback();
//            } catch (SQLException e2) {
//                System.out.println("Couldn't perform rollback");
//            }
//        }
//    }
//
//    public List<User> getAllUsers() {
//        String getUsers = "SELECT * FROM users";
//        try (Statement statement = connection.createStatement();
//             ResultSet results = statement.executeQuery(getUsers)) {
//
//            List<User> returnedUsers = new LinkedList<>();
//
//            while (results.next()) {
//                User temp = new User();
//                temp.setId(results.getLong(1));
//                temp.setName(results.getString(2));
//                temp.setLastName(results.getString(3));
//                temp.setAge(results.getByte(4));
//                returnedUsers.add(temp);
//            }
//            return returnedUsers;
//        } catch (SQLException e) {
//            System.out.println("Couldn't get users:" + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public void cleanUsersTable() {
//        String deleteUsers = "DELETE FROM users";
//        try (Statement statement = connection.createStatement()) {
//            statement.executeUpdate(deleteUsers);
//            connection.commit();
//        } catch (SQLException e) {
//            System.out.println("Couldn't clear the table:" + e.getMessage());
//            e.printStackTrace();
//            try {
//                connection.rollback();
//            } catch (SQLException e2) {
//                System.out.println("Couldn't perform rollback");
//            }
//
//        }
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
}
