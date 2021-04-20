package com.example.harjoitustyo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Context context = null;

    Button saveButton;
    Button wasteButton;
    EditText name_t;
    EditText height_t;
    EditText weight_t;
    TextView yourBMI;

    String name="";
    String height="1";
    String weight="1";

    User user = new User();
    Calculator calc = Calculator.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        context = MainActivity.this;

        name_t = (EditText) findViewById(R.id.editTextTextPersonName);
        height_t = (EditText) findViewById(R.id.editTextHeight);
        weight_t = (EditText) findViewById(R.id.editTextWeight);
        yourBMI = (TextView) findViewById(R.id.textView14);

        saveButton = (Button) findViewById(R.id.button2);
        wasteButton = (Button) findViewById(R.id.button);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void saveInfo(View v) {
        /* Saves the user's information on a user-object */
        name = name_t.getText().toString();
        height = height_t.getText().toString();
        weight = weight_t.getText().toString();
        user.setName(name);
        user.setHeight(height);
        user.setWeight(weight);
    }

    public void loadActivity(View v) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

    public void calculateBMI(View v) {
        /* Get's height and weight from user-object, sends them to calculator-method and prints out the result. */
        double h = user.getHeight();
        double w = user.getWeight();
        String n = user.getName();
        double bmi = calc.calculateBMI(h, w);
        yourBMI.setText("Hei " +n + "! Painoindeksisi on: "+ String.format("%.2f",bmi));

    }


}