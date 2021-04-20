package com.example.harjoitustyo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity2 extends AppCompatActivity {
    Context context = null;
    EntryManager eManager = EntryManager.getInstance();
    private StringBuilder text = new StringBuilder();

    Spinner biospin;
    Spinner cartonspin;
    Spinner electspin;
    Spinner glasspin;
    Spinner hazspin;
    Spinner metalspin;
    Spinner paperspin;
    Spinner plasticspin;
    Spinner amountspin;
    TextView yourCO;

    String[] options = {"aina", "usein", "joskus", "en koskaan"};
    String[] optionsAm = {"paljon", "jonkin verran", "vähän"};

    String bioWaste = "always";
    String cartonWaste = "always";
    String electWaste = "always";
    String glassWaste = "always";
    String hazardWaste = "always";
    String metalWaste = "always";
    String paperWaste = "always";
    String plasticWaste = "always";
    String amount = "high";
    String emissions = "";
    double dEmissions;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context = MainActivity2.this;
        System.out.println("KANSION SIJAINTI: " + context.getFilesDir());
        biospin = findViewById(R.id.spinnerBio);
        cartonspin = findViewById(R.id.spinnerCarton);
        electspin = findViewById(R.id.spinnerElect);
        glasspin = findViewById(R.id.spinnerGlass);
        hazspin = findViewById(R.id.spinnerHaz);
        metalspin = findViewById(R.id.spinnerMetal);
        paperspin = findViewById(R.id.spinnerPaper);
        plasticspin = findViewById(R.id.spinnerPlastic);
        amountspin = findViewById(R.id.spinnerAmount);
        yourCO = findViewById(R.id.textView13);

        /* Setting the correct options to the spinner menus */
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        ArrayAdapter<String> ad2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, optionsAm);

        biospin.setAdapter(ad);
        cartonspin.setAdapter(ad);
        electspin.setAdapter(ad);
        glasspin.setAdapter(ad);
        hazspin.setAdapter(ad);
        metalspin.setAdapter(ad);
        paperspin.setAdapter(ad);
        plasticspin.setAdapter(ad);
        amountspin.setAdapter(ad2);

        /* Placing listeners on all the spinners, user's choices are saved as variables*/
        biospin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        bioWaste = "always";
                        break;
                    case 1:
                        bioWaste = "often";
                        break;
                    case 2:
                        bioWaste = "sometimes";
                        break;
                    case 3:
                        bioWaste = "never";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        cartonspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        cartonWaste = "always";
                        break;
                    case 1:
                        cartonWaste = "often";
                        break;
                    case 2:
                        cartonWaste = "sometimes";
                        break;
                    case 3:
                        cartonWaste = "never";
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        electspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        electWaste = "always";
                        break;
                    case 1:
                        electWaste = "often";
                        break;
                    case 2:
                        electWaste = "sometimes";
                        break;
                    case 3:
                        electWaste = "never";
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        glasspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        glassWaste = "always";
                        break;
                    case 1:
                        glassWaste = "often";
                        break;
                    case 2:
                        glassWaste = "sometimes";
                        break;
                    case 3:
                        glassWaste = "never";
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        hazspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        hazardWaste = "always";
                        break;
                    case 1:
                        hazardWaste = "often";
                        break;
                    case 2:
                        hazardWaste = "sometimes";
                        break;
                    case 3:
                        hazardWaste = "never";
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        metalspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        metalWaste = "always";
                        break;
                    case 1:
                        metalWaste = "often";
                        break;
                    case 2:
                        metalWaste = "sometimes";
                        break;
                    case 3:
                        metalWaste = "never";
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        paperspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        paperWaste = "always";
                        break;
                    case 1:
                        paperWaste = "often";
                        break;
                    case 2:
                        paperWaste = "sometimes";
                        break;
                    case 3:
                        paperWaste = "never";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        plasticspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        plasticWaste = "always";
                        break;
                    case 1:
                        plasticWaste = "often";
                        break;
                    case 2:
                        plasticWaste = "sometimes";
                        break;
                    case 3:
                        plasticWaste = "never";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        amountspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        amount = "high";
                        break;
                    case 1:
                        amount = "normal";
                        break;
                    case 2:
                        amount = "low";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }



    public void countWaste(View v) {
        /* Counting the emission estimates based on the user's answers. Estimates are from Ilmastodieetti's Waste caluclator API. The estimate is printed on the screen for the user to see.  */

        String urladdress = "https://ilmastodieetti.ymparisto.fi/ilmastodieetti/calculatorapi/v1/WasteCalculator?query.bioWaste="+bioWaste+"&query.carton="+cartonWaste+"&query.electronic="+electWaste+"&query.glass="+glassWaste+"&query.hazardous="+hazardWaste+"&query.metal="+metalWaste+"&query.paper="+paperWaste+"&query.plastic="+plasticWaste+"&query.amountEstimate="+amount;
        System.out.println(urladdress);

        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(urladdress);

            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream();
            InputStreamReader isw = new InputStreamReader(in);

            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                emissions = emissions + current;
            }
            dEmissions = Double.parseDouble(emissions);
            yourCO.setText("Jätedieettisi on " + String.format("%.2f",dEmissions) + "kg CO2 vuodessa");
            emissions = "";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    public void saveData(View v) {
        /* A new entry-object is created with the information saved by the user. Data from the object is saved in a file "userlog.txt" */
        WasteEntry entry = new WasteEntry(bioWaste, cartonWaste, electWaste, glassWaste, hazardWaste, metalWaste, paperWaste, plasticWaste, amount, dEmissions);
        try {
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput("userlog.txt", Context.MODE_APPEND));
            // OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput("userlog.txt", Context.MODE_PRIVATE));
            eManager.writeEntry(entry, ows);
        } catch (IOException e) {
            e.printStackTrace(); }
    }

    public void readData(View v) {
        /* Data is read from the userlog-file and a new activity is opened, where the contents of the file can be viewed */
        try {
            InputStream ins = context.openFileInput("userlog.txt");
            eManager.readEntry(ins, text);

            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra("file", (Serializable) text);
            startActivity(intent);

            } catch (IOException e) {
                e.printStackTrace();
            }

    }

}

