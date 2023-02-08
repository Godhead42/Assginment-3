package org.example;

public class Samsung extends Smartphone{
    private static final String brandName = "Samsung";

    public Samsung(int id, double electronicWeight, int electronicPrice, String madeCountry, String phonebrandSeries, String phonebrandSeriesNumber, int phonememorySize, String phoneOS, String phoneCapacity) {
        super(id, Samsung.brandName, electronicWeight, electronicPrice, madeCountry, phonebrandSeries, phonebrandSeriesNumber, phonememorySize, phoneOS, phoneCapacity);
    }
}
