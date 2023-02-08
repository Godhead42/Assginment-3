package org.example;

public class Xiaomi extends Smartphone{
    private static final String brandName = "Xiaomi";

    public Xiaomi(int id, double electronicWeight, int electronicPrice, String madeCountry, String phonebrandSeries, String phonebrandSeriesNumber, int phonememorySize, String phoneOS, String phoneCapacity) {
        super(id, Xiaomi.brandName, electronicWeight, electronicPrice, madeCountry, phonebrandSeries, phonebrandSeriesNumber, phonememorySize, phoneOS, phoneCapacity);
    }
}
