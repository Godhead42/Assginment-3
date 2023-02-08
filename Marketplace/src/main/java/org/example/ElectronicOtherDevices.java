package org.example;

public class ElectronicOtherDevices  extends Electronics{
    private static final String electronicCategory = "Other devices";

    public ElectronicOtherDevices(int id, String electronictypeofCategory, String electronicbrandName, double electronicWeight, int electronicPrice, String madeCountry) {
        super(id, ElectronicOtherDevices.electronicCategory, electronictypeofCategory, electronicbrandName, electronicWeight, electronicPrice, madeCountry);
    }
}
