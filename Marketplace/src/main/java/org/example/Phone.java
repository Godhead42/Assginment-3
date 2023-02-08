package org.example;

public class Phone extends Electronics{
    private String phonebrandSeries;
    private String phonebrandSeriesNumber;
    private int phonememorySize;
    private String phoneOS;
    private String phoneCapacity;
    private static final String electronicCategory = "Phone";

    public Phone(int id, String electronictypeofCategory, String electronicbrandName, double electronicWeight, int electronicPrice, String madeCountry, String phonebrandSeries, String phonebrandSeriesNumber, int phonememorySize, String phoneOS, String phoneCapacity) {
        super(id, Phone.electronicCategory, electronictypeofCategory, electronicbrandName, electronicWeight, electronicPrice, madeCountry);
        this.phonebrandSeries = phonebrandSeries;
        this.phonebrandSeriesNumber = phonebrandSeriesNumber;
        this.phonememorySize = phonememorySize;
        this.phoneOS = phoneOS;
        this.phoneCapacity = phoneCapacity;
    }

    public String getPhonebrandSeries() {
        return phonebrandSeries;
    }

    public void setPhonebrandSeries(String phonebrandSeries) {
        this.phonebrandSeries = phonebrandSeries;
    }

    public String getPhonebrandSeriesNumber() {
        return phonebrandSeriesNumber;
    }

    public void setPhonebrandSeriesNumber(String phonebrandSeriesNumber) {
        this.phonebrandSeriesNumber = phonebrandSeriesNumber;
    }

    public int getPhonememorySize() {
        return phonememorySize;
    }

    public void setPhonememorySize(int phonememorySize) {
        this.phonememorySize = phonememorySize;
    }

    public String getPhoneOS() {
        return phoneOS;
    }

    public void setPhoneOS(String phoneOS) {
        this.phoneOS = phoneOS;
    }

    public String getPhoneCapacity() {
        return phoneCapacity;
    }

    public void setPhoneCapacity(String phoneCapacity) {
        this.phoneCapacity = phoneCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + "Phone{" +
                ", phonebrandSeries='" + phonebrandSeries + '\'' +
                ", phonebrandSeriesNumber='" + phonebrandSeriesNumber + '\'' +
                ", phonememorySize='" + phonememorySize + '\'' +
                ", phoneOS='" + phoneOS + '\'' +
                ", phoneCapacity='" + phoneCapacity + '\'' +
                '}';
    }
}
