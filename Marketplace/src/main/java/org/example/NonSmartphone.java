package org.example;

public class NonSmartphone extends Phone {
    private static final String electronictypeofCategory = "Non-Smartphone";

    public NonSmartphone(int id, String electronicbrandName, double electronicWeight, int electronicPrice, String madeCountry, String phonebrandSeries, String phonebrandSeriesNumber, int phonememorySize, String phoneOS, String phoneCapacity) {
        super(id, NonSmartphone.electronictypeofCategory, electronicbrandName, electronicWeight, electronicPrice, madeCountry, phonebrandSeries, phonebrandSeriesNumber, phonememorySize, phoneOS, phoneCapacity);
    }


}