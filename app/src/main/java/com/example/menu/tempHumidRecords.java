package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;

import java.util.Objects;

public class tempHumidRecords extends AppCompatActivity {

    private LineChart lineChart;
    private BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_humid_records);

        // Back button
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        // Set app bar title
        getSupportActionBar().setTitle("Records");

        // Setup charts
        lineChart = findViewById(R.id.tempChart);
        barChart = findViewById(R.id.humidChart);


        configureLineChart();
        configureBarChart();
    }

    private void configureBarChart() {
    }

    private void configureLineChart() {
    }


    // (2, 2021, 3, 31, 160220, 26.6, 33.6), (3, 2021, 3, 31, 160225, 26.7, 33.7)]

}