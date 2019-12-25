package com.example.new_serveasy.models;


public class Garage {

    private String GarageName;
    private String GarageLocation;

    public Garage(String GarageName, String GarageLocation) {
        this.GarageName = GarageName;
        this.GarageLocation = GarageLocation;
    }

    public String getGarageName() {
        return GarageName;
    }

    public void setGarageName(String GarageName) {
        this.GarageName = GarageName;
    }

    public String getGarageLocation() {
        return GarageLocation;
    }

    public void setGarageLocation(String GarageLocation) {
        this.GarageLocation = GarageLocation;
    }
}
