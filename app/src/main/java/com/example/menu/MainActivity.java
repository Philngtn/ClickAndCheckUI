package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define Cardview must be inside onCreate if not -> CRASH
        CardView weatherCard = findViewById(R.id.weatherCard);
        CardView soilCard = findViewById(R.id.soilCard);
        CardView farmerCard = findViewById(R.id.farmerCard);
        CardView goalCard = findViewById(R.id.goalCard);


        weatherCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "Weather Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        soilCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showSoilIndexs = new Intent(MainActivity.this,soilActivity.class);
                startActivity(showSoilIndexs);
                //Toast.makeText(MainActivity.this, "Soil Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        farmerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Farmer Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        goalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Goal Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}