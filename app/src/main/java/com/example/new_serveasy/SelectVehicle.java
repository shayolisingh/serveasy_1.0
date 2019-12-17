package com.example.new_serveasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class SelectVehicle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_vehicle);


        CardView CarCardView = findViewById(R.id.car_cardview);
        CardView BikeCardView = findViewById(R.id.bike_cardview);



    }
}
