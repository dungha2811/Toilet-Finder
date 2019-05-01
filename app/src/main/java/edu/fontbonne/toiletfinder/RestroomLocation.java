package edu.fontbonne.toiletfinder;

import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class RestroomLocation {
    private  String restroomName;
    private double latitude;
    private double longitude;


    public RestroomLocation(String restroomName, double latitude, double longitude) {
        this.restroomName = restroomName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getRestroomName() {
        return restroomName;
    }

    public void setRestroomName(String restroomName) {
        this.restroomName = restroomName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
