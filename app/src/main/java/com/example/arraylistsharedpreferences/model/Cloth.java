package com.example.arraylistsharedpreferences.model;

public class Cloth {

    private String clothName;
    private int highPrice;
    private int mediumPrice;
    private int averagePrice;
    private int lowPrice;
    private int totalPrice;

    public Cloth() {
    }

    public Cloth(String clothName, int highPrice, int mediumPrice, int averagePrice, int lowPrice, int totalPrice) {
        this.clothName = clothName;
        this.highPrice = highPrice;
        this.mediumPrice = mediumPrice;
        this.averagePrice = averagePrice;
        this.lowPrice = lowPrice;
        this.totalPrice = totalPrice;
    }

    public String getClothName() {
        return clothName;
    }

    public void setClothName(String clothName) {
        this.clothName = clothName;
    }

    public int getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(int highPrice) {
        this.highPrice = highPrice;
    }

    public int getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(int mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public int getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(int averagePrice) {
        this.averagePrice = averagePrice;
    }

    public int getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(int lowPrice) {
        this.lowPrice = lowPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
