package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Objects;

public class tempHumidRecords extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_humid_records);

        // Back button
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        // Set app bar title
        getSupportActionBar().setTitle("Records");

    }
}