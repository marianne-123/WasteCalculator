package com.example.harjoitustyo;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntryManager {
    private static EntryManager enma = new EntryManager();

    public EntryManager() {
    }

    public static EntryManager getInstance() {
        /* EntryManager is created as a singleton, because there only needs to be one entry manager */
        return enma; }

    public void writeEntry(WasteEntry entry, OutputStreamWriter ows) {
        /* Takes entry-object and outPutStreamWriter as parameters. Translates and writes the values of the entry-object and their date into the txt-file specified by the outPutStreamWriter. */
        try {
            String bio = entry.getBio();
            String car = entry.getCarton();
            String ele = entry.getElectric();
            String gla = entry.getGlass();
            String haz = entry.getHazard();
            String met = entry.getMetal();
            String pap = entry.getPaper();
            String pla = entry.getPlastic();
            String am = entry.getAmount();
            double co = entry.getCo2();
            String date = entry.getDate();
            ows.write("Pvm: " + date + "\n");
            ows.write("KIERRÄTÄT JÄTTEESI NÄIN USEIN: \n");
            ows.write("Biojätteen: " + entry.translateFi(bio) + "\n");
            ows.write("Pahvijätteen: " + entry.translateFi(car) + "\n");
            ows.write("Elektroniikkajätteen: " + entry.translateFi(ele) + "\n");
            ows.write("Lasin: " + entry.translateFi(gla) + "\n");
            ows.write("Ongelmajätteen: " + entry.translateFi(haz) + "\n");
            ows.write("Metallijätteen: " + entry.translateFi(met) + "\n");
            ows.write("Paperijätteen: " + entry.translateFi(pap) + "\n");
            ows.write("Muovijätteen: " + entry.translateFi(pla) + "\n");
            ows.write("Jätteiden määrä yhteensä: " + entry.translateFi(am) + "\n");
            ows.write("Jätteidesi tuottama hiilijalanjälki on vuodessa "+ co + "kg\n\n");
            ows.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("KIRJOITETTU");
        }
    }

    public void readEntry(InputStream ins, StringBuilder text) {
        /* Takes inputstream and a stringbuilder as parameters. Reads the file and saves it into the Stringbuilder. */
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String s="";

            while ((s = br.readLine()) != null) {
                System.out.println(s);
                text.append(s+"\n");
            }
            System.out.println(text);
            ins.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("LUETTU");
        }
    }

}