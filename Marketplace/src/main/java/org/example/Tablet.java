package org.example;

public class Tablet extends Electronics{
    private static final String electronicCategory = "Tablet";
    private String tabletCategory;
    private String tabletbrandSeries;
    private String tabletSeriesNumber;
    private String tabletMemorySize;
    private String tabletOS;
    private String tabletCapacity;

    public Tablet(int id, String electronictypeofCategory, String electronicbrandName, double electronicWeight, int electronicPrice, String madeCountry) {
        super(id, Tablet.electronicCategory, electronictypeofCategory, electronicbrandName, electronicWeight, electronicPrice, madeCountry);
    }
}
