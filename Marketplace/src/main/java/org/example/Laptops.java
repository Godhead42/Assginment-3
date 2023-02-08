package org.example;

public class Laptops extends Computer{
    private static final String  electronictypeofCategory = "Laptop";
    public Laptops(int id, String electronicbrandName, double electronicWeight, int electronicPrice, String madeCountry, String computerbrandSeries, String computerSeriesNumber, int computerMemorySize, String computerOS, String processor, int RAM, int numberOfCores, String videoCart) {
        super(id, Laptops.electronictypeofCategory, electronicbrandName, electronicWeight, electronicPrice, madeCountry, computerbrandSeries, computerSeriesNumber, computerMemorySize, computerOS, processor, RAM, numberOfCores, videoCart);
    }
}
