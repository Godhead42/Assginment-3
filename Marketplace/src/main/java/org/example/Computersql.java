package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Computersql {
    private static final ElectronicDB ElectronicDB = new ElectronicDB();

    private static final Statement statement;

    static {
        try {
            statement = ElectronicDB.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Computer> setLists(String sql) {
        String querry = sql;
        ArrayList<Computer> list = new ArrayList<>();
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
                String processor = resultset.getString(8);
                int RAM = resultset.getInt(9);
                int numberOfCores= resultset.getInt(10);
                String videoCart = resultset.getString(11);
                double Weight = resultset.getDouble(12);
                int price = resultset.getInt(13);
                String country = resultset.getString(14);
                String color = resultset.getString(15);
                if(Category ==" Personal Computer"){
                    list.add(new PersonalComputer(id, brandName, Weight, price, country,brandSeries, brandSeriesNumber,MemorySize,OS,processor,RAM,numberOfCores,videoCart));
                }
                if(Category =="Laptop"){
                    list.add(new Laptops(id, brandName, Weight, price, country,brandSeries, brandSeriesNumber,MemorySize,OS,processor,RAM,numberOfCores,videoCart));
                }
                }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
