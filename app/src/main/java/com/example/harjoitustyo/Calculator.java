package com.example.harjoitustyo;

public class Calculator {
    private static Calculator calc = new Calculator();

    public Calculator() {
    }

    public static Calculator getInstance() {
        /* Calculator is created as a singleton, because there only needs to be one calculator */
        return calc; }

    public double calculateBMI (double h, double w) {
        /* Takes user's height and weight as parameters, returns BMI value */
        System.out.println("PITUUS " + h);
        System.out.println("PAINO " + w);
        h = h/100;
        double bmi = w/(h*h);
        return bmi;
    }
}
