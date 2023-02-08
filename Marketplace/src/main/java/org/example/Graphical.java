package org.example;

public class Graphical extends Tablet{
    private static final String  electronictypeofCategory = "Graphical";
    public Graphical(int id, String electronicbrandName, double electronicWeight, int electronicPrice, String madeCountry) {
        super(id, Graphical.electronictypeofCategory, electronicbrandName, electronicWeight, electronicPrice, madeCountry);
    }
}
