package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class soilActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil2);

        // Back button
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // Define the variable
        CardView tempCard = findViewById(R.id.tempCard);
        CardView humiCard = findViewById(R.id.humiCard);
        final sensorService sensorService = new sensorService(soilActivity.this);
        final TextView textViewTemp = (TextView) findViewById(R.id.temperatureShow);
        final TextView textViewHumi = (TextView) findViewById(R.id.humidityShow);

        // Set initial display sensor values after click to Soil page
        sensorService.getTemp(new sensorService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(soilActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                textViewTemp.setText("N/A");
            }

            @Override
            public void onResponse(String response) {
                textViewTemp.setText(response + "°C");
            }
        });
        sensorService.getHumi(new sensorService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(soilActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                textViewHumi.setText("N/A");
            }

            @Override
            public void onResponse(String response) {
                textViewHumi.setText(response + "%");
            }
        });

        // Set click update temp or humidity
        tempCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sensorService.getTemp(new sensorService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(soilActivity.this, "Error: " + message , Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(String response) {
                        textViewTemp.setText(response + "°C");
                        Toast.makeText(soilActivity.this, "Returned temperature: " + response , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        humiCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sensorService.getHumi(new sensorService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(soilActivity.this, "Error: " + message , Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response) {
                        textViewHumi.setText(response + "%");
                        Toast.makeText(soilActivity.this, "Returned humidity: " + response , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }


}