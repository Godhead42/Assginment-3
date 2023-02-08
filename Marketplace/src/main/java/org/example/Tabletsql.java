package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Tabletsql {
    private static final ElectronicDB ElectronicDB = new ElectronicDB();

    private static final Statement statement;

    static {
        try {
            statement = ElectronicDB.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Tablet> setLists(String sql) {
        String querry = sql;
        ArrayList<Tablet> list = new ArrayList<>();
        try {
            ResultSet resultset = statement.executeQuery(querry);
            while (resultset.next()){
                int id=resultset.getInt(1);
                String Category = resultset.getString(2);
                String brandName= resultset.getString(3);
                String brandSeries = resultset.getString(4);
                String brandSeriesNumber = resultset.getString((5));
                int MemorySize = resultset.getInt(6);
                String OS = resultset.getString(7);
                int capacity = resultset.getInt(8);
                double Weight = resultset.getDouble(10);
                int price = resultset.getInt(11);
                String country = resultset.getString(9);
                if(Category == "Kids"){
                    list.add(new Kids(id,brandName,Weight, price, country));
                }
                if(Category == "Graphical"){
                    list.add(new Graphical(id,brandName,Weight, price, country));
                }

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
