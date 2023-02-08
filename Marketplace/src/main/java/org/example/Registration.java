package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Registration {
    Scanner scanner = new Scanner(System.in);
    private static final ElectronicDB ElectronicDB = new ElectronicDB();
    User user = null;
    private static final Statement statement;

    static {
        try {
            statement = ElectronicDB.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void registration() {
        System.out.println("Please enter username");
        String username = scanner.nextLine();
        System.out.println("Please enter password");
        String password1 = scanner.nextLine();
        System.out.println("Please repeat password");
        String password2 = scanner.nextLine();
        if (new String(password1).equals(password2)) {
            try {
                statement.executeUpdate("INSERT INTO `users`(`id`, `username`, `password`) VALUES (DEFAULT,'" + username + "','" + password1 + "')");
                this.user = new User(username, password2);
            }catch (SQLException e){
                e.printStackTrace();
            }
        } else {
            System.out.println("No valid data!");
        }
    }
}