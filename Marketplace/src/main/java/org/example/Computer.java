package org.example;

public class Computer extends Electronics{
    private static final String electronicCategory = "Computer";
    private String computerbrandSeries;
    private String computerSeriesNumber;
    private int computerMemorySize;
    private String computerOS;
    private String processor;
    private int RAM;
    private int numberOfCores;
    private String VideoCart;

    public Computer(int id, String electronictypeofCategory, String electronicbrandName, double electronicWeight, int electronicPrice, String madeCountry, String computerbrandSeries, String computerSeriesNumber, int computerMemorySize, String computerOS, String processor, int RAM, int numberOfCores, String videoCart) {
        super(id, Computer.electronicCategory, electronictypeofCategory, electronicbrandName, electronicWeight, electronicPrice, madeCountry);
        this.computerbrandSeries = computerbrandSeries;
        this.computerSeriesNumber = computerSeriesNumber;
        this.computerMemorySize = computerMemorySize;
        this.computerOS = computerOS;
        this.processor = processor;
        this.RAM = RAM;
        this.numberOfCores = numberOfCores;
        VideoCart = videoCart;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public String getVideoCart() {
        return VideoCart;
    }

    public void setVideoCart(String videoCart) {
        VideoCart = videoCart;
    }

    public String getComputerbrandSeries() {
        return computerbrandSeries;
    }

    public void setComputerbrandSeries(String computerbrandSeries) {
        this.computerbrandSeries = computerbrandSeries;
    }

    public String getComputerSeriesNumber() {
        return computerSeriesNumber;
    }

    public void setComputerSeriesNumber(String computerSeriesNumber) {
        this.computerSeriesNumber = computerSeriesNumber;
    }

    public int getComputerMemorySize() {
        return computerMemorySize;
    }

    public void setComputerMemorySize(int computerMemorySize) {
        this.computerMemorySize = computerMemorySize;
    }

    public String getComputerOS() {
        return computerOS;
    }

    public void setComputerOS(String computerOS) {
        this.computerOS = computerOS;
    }


}
