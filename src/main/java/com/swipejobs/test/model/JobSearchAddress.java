package com.swipejobs.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobSearchAddress {

    private String unit;
    private double maxJobDistance;
    private String longitude;
    private String latitude;

    public double getMaxJobDistance() {
        return maxJobDistance;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

}