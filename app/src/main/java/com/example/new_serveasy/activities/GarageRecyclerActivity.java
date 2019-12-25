package com.example.new_serveasy.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.new_serveasy.R;
import com.example.new_serveasy.adapters.GarageAdapter;
import com.example.new_serveasy.models.Garage;
import java.util.ArrayList;

public class GarageRecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage_recyler);


        //TODO: Create Dummy Data
        ArrayList<Garage> garages = getDummyData();

        //TODO: Bind Recycler View
        RecyclerView garageRecyclerView = findViewById(R.id.garage_recycler_view);

        //TODO: Layout Manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        garageRecyclerView.setLayoutManager(linearLayoutManager);

        //TODO: View Model and Adapter
        GarageAdapter garagesAdapter = new GarageAdapter(garages);
        garageRecyclerView.setAdapter(garagesAdapter);


    }

    private ArrayList<Garage> getDummyData() {

        ArrayList<Garage> garages = new ArrayList<>();

        garages.add(new Garage("Bikers Den", "Kothrud"));
        garages.add(new Garage("Vroom Auto Repair", "Kothrud"));
        garages.add(new Garage("Vehicle Gurus", "Kothrud"));
        garages.add(new Garage("Anand Garage", "Kothrud"));
        garages.add(new Garage("Car o Care", "Kothrud"));
        garages.add(new Garage("Vehicle Ninjas", "Kothrud"));
        garages.add(new Garage("Automech Garages", "Kothrud"));
        garages.add(new Garage("Sai Auto Garage", "Kothrud"));
        garages.add(new Garage("Vehicle Point", "Kothrud"));
        garages.add(new Garage("Car Care", "Kothrud"));


        return garages;
    }



}
