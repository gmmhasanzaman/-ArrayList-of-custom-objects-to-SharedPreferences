package com.example.arraylistsharedpreferences.model;

public class ExampleItem {
    private String mLine1;
    private String mLine2;
    private int number;

    public ExampleItem() {
    }

    public ExampleItem(String mLine1, String mLine2, int number) {
        this.mLine1 = mLine1;
        this.mLine2 = mLine2;
        this.number = number;
    }

    public ExampleItem(String line1, String line2) {
        mLine1 = line1;
        mLine2 = line2;
    }

    public String getmLine1() {
        return mLine1;
    }

    public void setmLine1(String mLine1) {
        this.mLine1 = mLine1;
    }

    public String getmLine2() {
        return mLine2;
    }

    public void setmLine2(String mLine2) {
        this.mLine2 = mLine2;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ExampleItem{" +
                "mLine1='" + mLine1 + '\'' +
                ", mLine2='" + mLine2 + '\'' +
                ", number=" + number +
                '}';
    }
}
