package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
//        Transaction transaction = null;
//        String dropTableQuery = "CREATE TABLE IF NOT EXISTS users (id int AUTO_INCREMENT PRIMARY KEY, name text, lastname text, age int)";
//
//        try (Session session = Util.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            Query query = session.createSQLQuery(dropTableQuery).addEntity(User.class);
//
//            transaction.commit();
//        } catch (Exception e) {
//            System.out.println("Couldn't create the table: " + e.getMessage());
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50), last_Name VARCHAR(50), " +
                "age TINYINT) AUTO_INCREMENT = 1";

        session.createSQLQuery(sql).addEntity(User.class).executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
//        Transaction transaction = null;
//        String dropTableQuery = "DROP TABLE IF EXISTS users";
//
//        try (Session session = getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            Query query = session.createNativeQuery(dropTableQuery);
//            query.executeUpdate();
//            transaction.commit();
//        } catch (Exception e) {
//            System.out.println("Couldn't drop the table: " + e.getMessage());
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DROP TABLE IF EXISTS users";

        session.createSQLQuery(sql).addEntity(User.class).executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;

        try (Session session = getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.save(new User(name, lastName, age));
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Couldn't save user: " + e.getMessage());
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        User user;

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = session.find(User.class, id);
            session.remove(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Couldn't delete user: " + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        String multipleQuery = "SELECT user FROM users user";
        try (Session session = getSessionFactory().openSession()) {
            return session.createQuery(multipleQuery, User.class).getResultList();

        } catch (Exception e) {
            System.out.println("Couldn't get users: " + e.getMessage());
            return null;
        }

    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        String deleteQuery = "DELETE FROM users";

        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery(deleteQuery).executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Couldn't clear the table: " + e.getMessage());
            if (transaction != null) {
                System.out.println("ROLLBACK");
                transaction.rollback();
            }
        }
    }
}
