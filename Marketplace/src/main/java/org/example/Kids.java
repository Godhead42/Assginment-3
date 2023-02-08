package org.example;

public class Kids extends Tablet{
    private static final String  electronictypeofCategory = "Graphical";
    public Kids(int id, String electronicbrandName, double electronicWeight, int electronicPrice, String madeCountry) {
        super(id, Kids.electronictypeofCategory, electronicbrandName, electronicWeight, electronicPrice, madeCountry);
    }
}
