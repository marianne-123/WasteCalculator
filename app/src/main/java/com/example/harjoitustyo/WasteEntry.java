package com.example.harjoitustyo;

public class WasteEntry extends Entry {

    private String amountEstimate;
    private String biowaste;
    private String carton;
    private String electric;
    private String glass;
    private String hazard;
    private String metal;
    private String paper;
    private String plastic;
    private double co2;

    public WasteEntry(String bio, String cart, String elec, String glas, String haz, String met, String pap, String pla, String amount, double co) {
        this.amountEstimate = amount;
        this.biowaste = bio;
        this.carton = cart;
        this.electric = elec;
        this.glass = glas;
        this.hazard = haz;
        this.metal = met;
        this.paper = pap;
        this.plastic = pla;
        this.co2 = co;
    }

    public String getAmount() { return amountEstimate; }
    public String getBio() { return biowaste; }
    public String getCarton() { return carton; }
    public String getElectric() { return electric; }
    public String getGlass() { return glass; }
    public String getHazard() { return hazard; }
    public String getMetal() { return metal; }
    public String getPaper() { return paper; }
    public String getPlastic() { return plastic; }
    public double getCo2() { return co2; }


}
