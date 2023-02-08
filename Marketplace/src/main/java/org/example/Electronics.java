package org.example;

public abstract class Electronics {
    private int id;
    private String electronicCategory;
    private String electronictypeofCategory;
    private String electronicbrandName;
    private double electronicWeight;
    private int electronicPrice;
    private String madeCountry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElectronicCategory() {
        return electronicCategory;
    }

    public void setElectronicCategory(String electronicCategory) {
        this.electronicCategory = electronicCategory;
    }

    public String getElectronictypeofCategory() {
        return electronictypeofCategory;
    }

    public void setElectronictypeofCategory(String electronictypeofCategory) {
        this.electronictypeofCategory = electronictypeofCategory;
    }

    public String getElectronicbrandName() {
        return electronicbrandName;
    }

    public void setElectronicbrandName(String electronicbrandName) {
        this.electronicbrandName = electronicbrandName;
    }

    public double getElectronicWeight() {
        return electronicWeight;
    }

    public void setElectronicWeight(int electronicWeight) {
        this.electronicWeight = electronicWeight;
    }

    public int getElectronicPrice() {
        return electronicPrice;
    }

    public void setElectronicPrice(int electronicPrice) {
        this.electronicPrice = electronicPrice;
    }

    public String getMadeCountry() {
        return madeCountry;
    }

    public void setMadeCountry(String madeCountry) {
        this.madeCountry = madeCountry;
    }


    public Electronics(int id, String electronicCategory, String electronictypeofCategory, String electronicbrandName, double electronicWeight, int electronicPrice, String madeCountry) {
        this.id = id;
        this.electronicCategory = electronicCategory;
        this.electronictypeofCategory = electronictypeofCategory;
        this.electronicbrandName = electronicbrandName;
        this.electronicWeight = electronicWeight;
        this.electronicPrice = electronicPrice;
        this.madeCountry = madeCountry;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "id=" + id +
                ", electronicCategory='" + electronicCategory + '\'' +
                ", electronictypeofCategory='" + electronictypeofCategory + '\'' +
                ", electronicbrandName='" + electronicbrandName + '\'' +
                ", electronicWeight=" + electronicWeight +
                ", electronicPrice='" + electronicPrice + '\'' +
                ", madeCountry='" + madeCountry + '\'' +
                '}';
    }
}
