package org.example;

public class Smartphone extends Phone{
    private static final String  electronictypeofCategory = "Smartphone";

    public Smartphone(int id, String electronicbrandName, double electronicWeight, int electronicPrice, String madeCountry, String phonebrandSeries, String phonebrandSeriesNumber, int phonememorySize, String phoneOS, String phoneCapacity) {
        super(id, Smartphone.electronictypeofCategory, electronicbrandName, electronicWeight, electronicPrice, madeCountry, phonebrandSeries, phonebrandSeriesNumber, phonememorySize, phoneOS, phoneCapacity);
    }
}
