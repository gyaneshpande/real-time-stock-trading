package com.example.StockTradingPlatform.model;

public class StockPrice {
    private double c; // Current price
    private double h; // High price of the day
    private double l; // Low price of the day
    private double o; // Open price of the day
    private double pc; // Previous close price
    private long t; // Timestamp

    // Getters and Setters

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    public double getO() {
        return o;
    }

    public void setO(double o) {
        this.o = o;
    }

    public double getPc() {
        return pc;
    }

    public void setPc(double pc) {
        this.pc = pc;
    }

    public long getT() {
        return t;
    }

    public void setT(long t) {
        this.t = t;
    }
}

