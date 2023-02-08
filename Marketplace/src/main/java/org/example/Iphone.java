package org.example;

public class Iphone extends Smartphone{
    private static final String brandName = "Iphone";

    public Iphone(int id, double electronicWeight, int electronicPrice, String madeCountry, String phonebrandSeries, String phonebrandSeriesNumber, int phonememorySize, String phoneOS, String phoneCapacity) {
        super(id, Iphone.brandName, electronicWeight, electronicPrice, madeCountry, phonebrandSeries, phonebrandSeriesNumber, phonememorySize, phoneOS, phoneCapacity);
    }
}
