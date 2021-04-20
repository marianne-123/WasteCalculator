package com.example.harjoitustyo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity3 extends AppCompatActivity {

    TextView textPrint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textPrint = (TextView) findViewById(R.id.textView15);
        textPrint.setMovementMethod(new ScrollingMovementMethod());
        Serializable text = getIntent().getSerializableExtra("file");
        textPrint.setText((CharSequence) text);
    }

    public void loadActivity(View v) {
        Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
        startActivity(intent);
    }
}