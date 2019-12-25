package com.example.new_serveasy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.new_serveasy.R;
import com.example.new_serveasy.activities.SearchActivity;
import com.example.new_serveasy.activities.VehicleDetails;

public class DashboardActivity extends AppCompatActivity {

    private CardView addVehicle, searchGarage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbard);


        addVehicle = findViewById(R.id.addvehicle_cv);
        searchGarage = findViewById(R.id.searchgarage_cv);


        addVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DashboardActivity.this, VehicleDetails.class));
                finish();

            }
        });


        searchGarage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, SearchActivity.class));
                finish();
            }
        });

    }
}
