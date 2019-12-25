package com.example.new_serveasy.models;


public class Vehicle {


    private String vehicleid;

    private String vehicleType;

    private String vehicleBrand;


    private String vehicleModel;
    private String fuelType;

    private String vehicleModelYear;


    private String vehicleRCNumber;

    public Vehicle()

    {
    }


    public Vehicle(String vehicleid, String vehicleType, String vehicleBrand, String vehicleModel, String fuelType, String vehicleModelYear, String vehicleRCNumber) {
        this.vehicleid = vehicleid;
        this.vehicleType = vehicleType;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.fuelType = fuelType;
        this.vehicleModelYear = vehicleModelYear;
        this.vehicleRCNumber = vehicleRCNumber;
    }

    public String getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(String vehicleid) {
        this.vehicleid = vehicleid;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getVehicleModelYear() {
        return vehicleModelYear;
    }

    public void setVehicleModelYear(String vehicleModelYear) {
        this.vehicleModelYear = vehicleModelYear;
    }

    public String getVehicleRCNumber() {
        return vehicleRCNumber;
    }

    public void setVehicleRCNumber(String vehicleRCNumber) {
        this.vehicleRCNumber = vehicleRCNumber;
    }
}