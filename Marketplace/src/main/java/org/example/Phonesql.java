package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Phonesql {
    private static final ElectronicDB ElectronicDB = new ElectronicDB();

    private static final Statement statement;

    static {
        try {
            statement = ElectronicDB.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Phone> setLists(String sql) {
        String querry = sql;
        ArrayList<Phone> list = new ArrayList<>();
        try {
            ResultSet resultset = statement.executeQuery(querry);
            while (resultset.next()){
                int id=resultset.getInt(1);
                String phoneCategory = resultset.getString(2);
                String brandName= resultset.getString(3);
                String brandSeries = resultset.getString(4);
                String brandSeriesNumber = resultset.getString((5));
                int phoneMemmorySize = resultset.getInt(6);
                String phoneOS = resultset.getString(7);
                String collor = resultset.getString(8);
                String country = resultset.getString(9);
                String phoneCapacity = resultset.getString(10);
                double phoneWeight = resultset.getDouble(11);
                int price = resultset.getInt(12);
                if(brandName=="Samsung"){list.add(new Samsung(id,phoneWeight,price,country,brandSeries,brandSeriesNumber,phoneMemmorySize,phoneOS,phoneCapacity));
                } else if (brandName=="Iphone") {
                    list.add(new Iphone(id,phoneWeight,price,country,brandSeries,brandSeriesNumber,phoneMemmorySize,phoneOS,phoneCapacity));
                } else if (brandName=="Xiaomi") {
                    list.add(new Xiaomi(id,phoneWeight,price,country,brandSeries,brandSeriesNumber,phoneMemmorySize,phoneOS,phoneCapacity));
                }else if(phoneCategory == "Non-smart phone"){
                    list.add(new NonSmartphone(id,brandName, phoneWeight, price,country,brandSeries, brandSeriesNumber, phoneMemmorySize, phoneOS, phoneCapacity));
                }else{
                    list.add(new PhoneOtherBrands(id,brandName, phoneWeight, price,country,brandSeries, brandSeriesNumber, phoneMemmorySize, phoneOS, phoneCapacity));
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
