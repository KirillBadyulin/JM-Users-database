package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("John", "Snow", (byte)23);
        System.out.println("User с именем – John добавлен в базу данных");
        userService.saveUser("Tyrion", "Lannister", (byte) 32);
        System.out.println("User с именем – Tyrion добавлен в базу данных");
        userService.saveUser("Arya", "Stark", (byte) 20);
        System.out.println("User с именем – Arya добавлен в базу данных");
        userService.saveUser("Daenerys", "Targaryen", (byte) 27);
        System.out.println("User с именем – Daenerys добавлен в базу данных");

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();

        Util.close();
    }
}
