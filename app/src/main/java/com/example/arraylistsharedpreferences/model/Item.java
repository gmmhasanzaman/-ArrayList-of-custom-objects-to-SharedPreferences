package com.example.arraylistsharedpreferences.model;

import java.io.Serializable;

public class Item implements Serializable {
    private String itemName;
    private int itemImage;
    private double itemMinPrice;

    public Item() {
    }

    public Item(String itemName, int itemImage, double itemMinPrice) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemMinPrice = itemMinPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public double getItemMinPrice() {
        return itemMinPrice;
    }

    public void setItemMinPrice(double itemMinPrice) {
        this.itemMinPrice = itemMinPrice;
    }
}
