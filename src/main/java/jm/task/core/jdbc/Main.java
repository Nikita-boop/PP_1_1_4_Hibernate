package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService test = new UserServiceImpl();
        test.createUsersTable();
        for (int i = 0; i < 4; i++) {
            String tempName = "Bob" + i;
            test.saveUser(tempName, "Marley", (byte)(i + 20));
            System.out.println("User: " + tempName + " was successfully added to DB");
        }


        List<User> testList= test.getAllUsers();
        if (testList.isEmpty()) {
            System.out.println("List is empty");
        } else {
            System.out.println("\n=== Users from DB ===");
            for (User print : testList) {
                System.out.println(print);
            }
        }/*
        test.cleanUsersTable();
        System.out.println("\nUsers were successfully removed from DB");
        test.dropUsersTable();
        System.out.println("\nTable with Users was successfully deleted from DB");*/
    }
}
