package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDaoHibernateImplInstance = new UserDaoHibernateImpl();

    public UserServiceImpl() {

    }

    public void createUsersTable() {
        userDaoHibernateImplInstance.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoHibernateImplInstance.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernateImplInstance.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoHibernateImplInstance.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoHibernateImplInstance.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoHibernateImplInstance.cleanUsersTable();
    }
}
