package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
    Scanner scanner = new Scanner(System.in);
    private static final ElectronicDB ElectronicDB = new ElectronicDB();
    User user= null;
    private static final Statement statement;

    static {
        try {
            statement = ElectronicDB.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void login(){
        System.out.println("Please enter username");
        String username = scanner.nextLine();
        System.out.println("Please enter password");
        String password1 = scanner.nextLine();
        String SQL = "SELECT * FROM users WHERE username = '"+username+"' and password = '"+password1+"'";
        try {
            ResultSet resultset = statement.executeQuery(SQL);
            while(resultset.next()){
                int id = resultset.getInt(1);

                if(id>0){
                    User user = new User(username,password1);
                    this.user = user;
                }else{
                    this.user = null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
