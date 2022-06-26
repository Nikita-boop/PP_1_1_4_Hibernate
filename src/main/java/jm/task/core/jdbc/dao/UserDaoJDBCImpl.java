package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    @Override
    public void createUsersTable() {
        /*dropUsersTable();
        try (Connection connection = (new Util()).getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE `mydbtest`.`user` ("
            + " `id` INT NOT NULL AUTO_INCREMENT,"
            + " `first_name` VARCHAR(45) NOT NULL,"
            + " `last_name` VARCHAR(45) NOT NULL,"
            + " `age` INT NOT NULL,"
            + " PRIMARY KEY (`id`))"
            + " ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;");
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }*/

    }
    @Override
    public void dropUsersTable() {
       /* try (Connection connection = (new Util()).getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS user;");
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }*/
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        /*try (Connection connection = (new Util()).getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO user(first_name, last_name, age) VALUES ('" + name + "', '" + lastName + "', " + age + ");");
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }*/
    }
    @Override
    public void removeUserById(long id) {
        /*try (Connection connection = (new Util()).getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM user where id = " + id);
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }*/
    }
    @Override
    public List<User> getAllUsers() {
        /*List<User> list = new ArrayList<>();
        try (Connection connection = (new Util()).getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                User temp = new User(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getByte("age"));
                temp.setId(resultSet.getLong("id"));
                list.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }
        return list;*/
        return null;
    }
    @Override
    public void cleanUsersTable() {
        /*try (Connection connection = (new Util()).getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("TRUNCATE TABLE user;");
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        }*/
    }
}
