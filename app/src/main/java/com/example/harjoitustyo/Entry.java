package com.example.harjoitustyo;

import android.icu.text.SimpleDateFormat;
import android.os.Build;

import java.util.Date;
import java.util.Locale;


public class Entry {

    private String date;

    public Entry() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        }
    }

    public String getDate() {
        return date;
    }

    public String translateFi(String s) {
        /* Translates user's answers to Finnish */
        if (s == "always") {
            return "aina";
        } else if (s == "often") {
            return "usein";
        } else if (s == "sometimes") {
            return "joskus";
        } else if (s == "never") {
            return "en koskaan";
        } else if (s == "low") {
            return "vähän";
        } else if (s == "high") {
            return "paljon";
        } else if (s == "normal") {
            return "jonkin verran";
        }
        return "";
    }
}
