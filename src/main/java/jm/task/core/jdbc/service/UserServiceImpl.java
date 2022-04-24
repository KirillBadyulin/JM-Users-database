package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private Util util = new Util();

    public void createUsersTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS users (id int AUTO_INCREMENT PRIMARY KEY, name text, lastname text, age int)";
        try {
            util.open();
            Statement statement = util.connection.createStatement();
            statement.execute(createTable);
            statement.close();
        } catch (SQLException e) {
            System.out.println("Couldn't create users table:" + e.getMessage());
            e.printStackTrace();
            util.close();
        } finally {
            util.close();
        }
    }

    public void dropUsersTable() {
        String dropTable = "DROP TABLE IF EXISTS users";
        try {
            util.open();
            Statement statement = util.connection.createStatement();
            statement.execute(dropTable);
            statement.close();
        } catch (SQLException e) {
            System.out.println("Couldn't create users table:" + e.getMessage());
            e.printStackTrace();
            util.close();
        } finally {
            util.close();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String addUser = "INSERT INTO users (name, lastName, age) VALUES ('" + name + "', '" + lastName + "', " + age + ")";

        try {
            util.open();
            Statement statement = util.connection.createStatement();
            statement.execute(addUser);
            statement.close();
        } catch (SQLException e) {
            System.out.println("Couldn't create users table:" + e.getMessage());
            e.printStackTrace();
            util.close();
        } finally {
            util.close();
        }
    }

    public void removeUserById(long id) {
        String removeUser = "DELETE FROM users WHERE id = " + id + "";
        try {
            util.open();
            Statement statement = util.connection.createStatement();
            statement.execute(removeUser);
            statement.close();
        } catch (SQLException e) {
            System.out.println("Couldn't create users table:" + e.getMessage());
            e.printStackTrace();
            util.close();
        } finally {
            util.close();
        }
    }

    public List<User> getAllUsers() {
        String getUsers = "SELECT * FROM users";
        try {
            util.open();
            Statement statement = util.connection.createStatement();
            ResultSet results = statement.executeQuery(getUsers);
            List<User> returnedUsers = new LinkedList<>();

            while (results.next()) {
                User temp = new User();
                temp.setId(results.getLong(1));
                temp.setName(results.getString(2));
                temp.setLastName(results.getString(3));
                temp.setAge(results.getByte(4));
                returnedUsers.add(temp);
            }
            results.close();
            statement.close();
            return returnedUsers;
        } catch (SQLException e) {
            System.out.println("Couldn't create users table:" + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            util.close();
        }
    }

    public void cleanUsersTable() {
        String deleteUsers = "DELETE FROM users";
        try {
            util.open();
            Statement statement = util.connection.createStatement();
            statement.execute(deleteUsers);
            statement.close();
        } catch (SQLException e) {
            System.out.println("Couldn't clear the table:" + e.getMessage());
            e.printStackTrace();
            util.close();
        } finally {
            util.close();
        }
    }
}
