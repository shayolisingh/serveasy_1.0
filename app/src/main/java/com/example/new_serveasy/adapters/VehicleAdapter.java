package com.example.new_serveasy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.new_serveasy.R;
import com.example.new_serveasy.models.Vehicle;

import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder> {

    private List<Vehicle> Vehicle;

    public VehicleAdapter(List<com.example.new_serveasy.models.Vehicle> vehicles) {
        Vehicle = vehicles;
    }

    @NonNull
    @Override
    public VehicleAdapter.VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_item, parent, false);

        return new VehicleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleAdapter.VehicleViewHolder holder, int position) {

        Vehicle v = Vehicle.get(position);
        holder.vTypeTV.setText(v.getVehicleType());
        holder.vBrandTV.setText(v.getVehicleBrand());
        holder.vModelTV.setText(v.getVehicleModel());
        holder.vModelYearTV.setText(v.getVehicleModelYear());
        holder.vFuelTye.setText(v.getFuelType());
        holder.vRCNumber.setText(v.getVehicleRCNumber());


    }

    @Override
    public int getItemCount() {
        return Vehicle.size();
    }

    public class VehicleViewHolder extends RecyclerView.ViewHolder {

        private TextView vTypeTV, vBrandTV, vModelTV, vModelYearTV, vFuelTye, vRCNumber;

        public VehicleViewHolder(@NonNull View itemView) {
            super(itemView);

            vTypeTV = itemView.findViewById(R.id.v_type_tv);
            vBrandTV = itemView.findViewById(R.id.v_brand_tv);
            vModelTV = itemView.findViewById(R.id.v_model_tv);
            vModelYearTV = itemView.findViewById(R.id.v_modelyear_tv);
            vFuelTye = itemView.findViewById(R.id.v_fueltype_tv);
            vRCNumber = itemView.findViewById(R.id.v_rcnumber_tv);
        }
    }
}
