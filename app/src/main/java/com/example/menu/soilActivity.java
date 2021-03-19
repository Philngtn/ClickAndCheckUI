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

        getTemp_n_Humi();

        tempCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(soilActivity.this);
                String url ="http://192.168.0.24:80/temp";

                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        String temp = "";
                        try {
                            JSONObject JSON_temp = response.getJSONObject(0);
                            temp = JSON_temp.getString("temp");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(soilActivity.this, temp , Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(soilActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

                // Add the request to the RequestQueue.
                queue.add(request);

            }
        });
        humiCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(soilActivity.this);
                String url ="http://192.168.0.24:80/humi";

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String humi = "";
                        humi = response.optString("humi");
                        Toast.makeText(soilActivity.this, humi , Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(soilActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

                // Add the request to the RequestQueue.
                queue.add(request);


                // Request a string response from the provided URL.
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                // Display the first 500 characters of the response string.
//                                Toast.makeText(soilActivity.this, response, Toast.LENGTH_SHORT).show();
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(soilActivity.this, "Error", Toast.LENGTH_SHORT).show();
//
//                    }
//                });


                //Toast.makeText(soilActivity.this, "Temp Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getTemp_n_Humi() {

        final TextView textViewTemp = (TextView) findViewById(R.id.temperatureShow);
        final TextView textViewHumi = (TextView) findViewById(R.id.humidityShow);

        // GET TEMP
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(soilActivity.this);
        String url ="http://192.168.0.24:80/temp";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String temp = "";
                try {
                    JSONObject JSON_temp = response.getJSONObject(0);
                    temp = JSON_temp.getString("temp");
                    textViewTemp.setText(temp + "°C");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textViewTemp.setText("N/A");
                Toast.makeText(soilActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(request);


        //////////////////////////////////////////////////////////////////////////////////////////////////

        // GET Humi
        // Instantiate the RequestQueue.
        RequestQueue queue2 = Volley.newRequestQueue(soilActivity.this);
        String url2 ="http://192.168.0.24:80/humi";

        JsonObjectRequest request2 = new JsonObjectRequest(Request.Method.GET, url2, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String humi = "";
                humi = response.optString("humi");
                textViewHumi.setText(humi + "%");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textViewHumi.setText("N/A");
            }
        });

        // Add the request to the RequestQueue.
        queue2.add(request2);

    }
}