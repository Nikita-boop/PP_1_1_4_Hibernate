package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao test = new UserDaoJDBCImpl();
        test.createUsersTable();
        test.saveUser("Bob", "Marley", (byte)47);
        test.saveUser("Bob", "Marley", (byte)47);
        test.removeUserById(1);
        List<User> testList= test.getAllUsers();
        if (testList.isEmpty()) {
            System.out.println("List is empty");
        }
        test.cleanUsersTable();
        test.dropUsersTable();
    }
}
