package com.example.new_serveasy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.new_serveasy.R;
import com.example.new_serveasy.models.Garage;

import java.util.ArrayList;

public class GarageAdapter extends RecyclerView.Adapter<GarageAdapter.GarageViewHolder> {

    private ArrayList<com.example.new_serveasy.models.Garage> Garage;

    public GarageAdapter(ArrayList<Garage> garages) {
        Garage = garages;
    }


    @NonNull
    @Override
    public GarageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.garage_item, parent, false);


        return new GarageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GarageViewHolder holder, int position) {


        Garage garages = Garage.get(position);
        holder.GarageNameTextView.setText(garages.getGarageName());
        holder.GarageLocationTextView.setText(garages.getGarageLocation());

    }

    @Override
    public int getItemCount() {
        return Garage.size();
    }

    public class GarageViewHolder extends RecyclerView.ViewHolder {

        private TextView GarageNameTextView, GarageLocationTextView;

        public GarageViewHolder(@NonNull View itemView) {
            super(itemView);
            GarageNameTextView = itemView.findViewById(R.id.garage_name);
            GarageLocationTextView = itemView.findViewById(R.id.garage_location);
        }
    }
}