package com.example.harjoitustyo;

public class User {

    private String name;
    private String height;
    private String weight;

    public User(String i, String j, String k) {
        this.name = i;
        this.height = j;
        this.weight = k;
    }

    public User() {}

    public void setName(String a) { this.name = a; }

    public void setHeight(String h) { this.height = h; }

    public void setWeight(String w) { this.weight = w; }

    public double getHeight() {
        double dHeight = Double.parseDouble(height);
        return dHeight;
    }

    public double getWeight() {
        double dWeight = Double.parseDouble(weight);
        return dWeight;
    }

    public String getName() {
        return this.name;
    }


}
