package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends Util implements UserService {

    Connection connection = getConnection();

    @Override
    public void createUsersTable() {
        dropUsersTable();
        PreparedStatement preparedStatement = null;
        String query = "CREATE TABLE `mydbtest`.`user` (" +
                "`id` INT NOT NULL AUTO_INCREMENT," +
                " `first_name` VARCHAR(45) NOT NULL," +
                " `last_name` VARCHAR(45) NOT NULL," +
                " `age` INT NOT NULL," +
                " PRIMARY KEY (`id`))" +
                " ENGINE = InnoDB" +
                " DEFAULT CHARACTER SET = utf8;";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Something went wrong in createUsersTable()...");
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable e) {
                System.out.println("Something went wrong in closing connection...");
            }
        }

    }

    @Override
    public void dropUsersTable() {
        PreparedStatement preparedStatement = null;
        String query = "DROP TABLE IF EXISTS user;";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Something went wrong in dropUsersTable()...");
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable e) {
                System.out.println("Something went wrong in closing connection...");
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO user(first_name, last_name, age) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Something went wrong saveUser()...");
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable e) {
                System.out.println("Something went wrong in closing connection...");
            }
        }
    }
    @Override
    public void removeUserById(long id) {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM user where id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable e) {
                System.out.println("Something went wrong in closing connection...");
            }
        }
    }
    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM user";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User temp = new User(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getByte("age"));
                temp.setId(resultSet.getLong("id"));
                list.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable e) {
                System.out.println("Something went wrong in closing connection...");
            }
        }
        return list;
    }
    @Override
    public void cleanUsersTable() {
        PreparedStatement preparedStatement = null;
        String query = "TRUNCATE TABLE user";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Something went wrong...");
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable e) {
                System.out.println("Something went wrong in closing connection...");
            }
        }
    }
}
