package com.example.epicodus_staff.foodtruckapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.epicodus_staff.foodtruckapp.R;
import com.example.epicodus_staff.foodtruckapp.model.FoodTruck;

import org.json.JSONArray;

import java.util.ArrayList;

public class FoodTrucksListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_trucks_list);

        String url = "http://138.197.214.133/api/v1/foodtruck";
        ArrayList<FoodTruck> foodTruckList = new ArrayList<>();

        final JsonArrayRequest getTrucks = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.v("messaging", response.toString()); //need to change to objects here.
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("API", "Error!!");
            }
        });
        Volley.newRequestQueue(this).add(getTrucks);

    }
}
