package com.example.new_serveasy.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.new_serveasy.R;
import com.example.new_serveasy.adapters.VehicleAdapter;
import com.example.new_serveasy.models.Vehicle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class VehicleRecyclerActivity extends AppCompatActivity {

    private List<Vehicle> Vehicle;
    private RecyclerView vehicleRecyclerView;
    private VehicleAdapter vehicleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_recycler);


        //binding views
        vehicleRecyclerView = findViewById(R.id.vehicle_recycler_view);
        vehicleRecyclerView.setHasFixedSize(true);
        vehicleRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Vehicle = new ArrayList<>();

        final DatabaseReference dbVehicle = FirebaseDatabase.getInstance().getReference("vehicles");
        dbVehicle.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    for (DataSnapshot vdatasnapshot : dataSnapshot.getChildren()) {
                        Vehicle v = vdatasnapshot.getValue(Vehicle.class);
                        Vehicle.add(v);

                    }

                    vehicleAdapter = new VehicleAdapter(Vehicle);
                    vehicleRecyclerView.setAdapter(vehicleAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
