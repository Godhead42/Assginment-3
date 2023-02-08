package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Othersql {
    private static final ElectronicDB ElectronicDB = new ElectronicDB();

    private static final Statement statement;

    static {
        try {
            statement = ElectronicDB.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<ElectronicOtherDevices> setLists(String sql) {
        String querry = sql;
        ArrayList<ElectronicOtherDevices> list = new ArrayList<>();
        try {
            ResultSet resultset = statement.executeQuery(querry);
            while (resultset.next()){
                int id=resultset.getInt(1);
                String Category = resultset.getString(2);
                String brandName= resultset.getString(3);
                double Weight = resultset.getDouble(4);
                int price = resultset.getInt(5);
                String country = resultset.getString(6);

                list.add(new ElectronicOtherDevices(id,Category,brandName,Weight,price,country));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
