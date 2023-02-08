package org.example;

public class PersonalComputer extends Computer{
    private static final String  electronictypeofCategory = "PersonalComputer";

    public PersonalComputer(int id, String electronicbrandName, double electronicWeight, int electronicPrice, String madeCountry, String computerbrandSeries, String computerSeriesNumber, int computerMemorySize, String computerOS, String processor, int RAM, int numberOfCores, String videoCart) {
        super(id, PersonalComputer.electronictypeofCategory, electronicbrandName, electronicWeight, electronicPrice, madeCountry, computerbrandSeries, computerSeriesNumber, computerMemorySize, computerOS, processor, RAM, numberOfCores, videoCart);
    }
}
