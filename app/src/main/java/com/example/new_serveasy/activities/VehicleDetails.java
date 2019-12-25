package com.example.new_serveasy.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.new_serveasy.R;
import com.example.new_serveasy.models.Vehicle;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class VehicleDetails extends AppCompatActivity {

    private Spinner brandSpinner, modelSpinner, modelYearSpinner;
    private EditText rcNumberEditText;
    private RadioButton petrolButton, dieselButton;

    DatabaseReference dbVehicle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_details);

        //get instance of firebase instance
        dbVehicle = FirebaseDatabase.getInstance().getReference("vehicles");

        //binding views
        brandSpinner = findViewById(R.id.brand_spinner);
        modelSpinner = findViewById(R.id.model_spninner);
        modelYearSpinner = findViewById(R.id.modelyear_spinner);
        rcNumberEditText = findViewById(R.id.rcnumber_edittext);
        petrolButton = findViewById(R.id.petrol_radio);
        dieselButton = findViewById(R.id.diesel_radio);


        findViewById(R.id.add_bike_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addBike();
                startActivity(new Intent(VehicleDetails.this, VehicleRecyclerActivity.class));
                finish();

            }
        });


    }

    private void addBike() {

        final String mBrand = brandSpinner.getSelectedItem().toString();
        final String mVehicleType = "Bike";
        final String mModel = modelSpinner.getSelectedItem().toString();
        String mFuelType = "";
        final String mModelYear = modelYearSpinner.getSelectedItem().toString();
        if (petrolButton.isChecked()) {
            mFuelType = petrolButton.getText().toString();
        }
        if (dieselButton.isChecked()) {
            mFuelType = dieselButton.getText().toString();

        }
        final String mRCNumber = rcNumberEditText.getText().toString();


        if (mBrand.equals("Brand")) {
            Toast.makeText(this, "Select Brand", Toast.LENGTH_SHORT).show();
            brandSpinner.requestFocus();
            return;
        } else if (mModel.equals("Model")) {
            Toast.makeText(this, "Select Model", Toast.LENGTH_SHORT).show();
            modelSpinner.requestFocus();
            return;
        } else if (mModelYear.equals("Year")) {
            Toast.makeText(this, "Select Model Year", Toast.LENGTH_SHORT).show();
            modelYearSpinner.requestFocus();
        } else if (mRCNumber.isEmpty()) {
//            rcNumberEditText.setError("Enter RC Number");
            Toast.makeText(this, "Enter R C Number", Toast.LENGTH_SHORT).show();
            rcNumberEditText.requestFocus();
        } else {

            String id = dbVehicle.push().getKey();

            Vehicle vehicle = new Vehicle(id, mVehicleType, mBrand, mModel, mFuelType, mModelYear, mRCNumber);
            dbVehicle.child(id).setValue(vehicle);
            Toast.makeText(this, "Vehicle Added Successfully", Toast.LENGTH_SHORT).show();
        }


    }
}