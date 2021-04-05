package com.swipejobs.test.util;

public interface DistanceCalculator {

    /**
     * calculates the distance between 2 coordinates
     * @param lat1 latitude of first location
     * @param lon1 longitude of first location
     * @param lat2 latitude of second location
     * @param lon2 longitude of second location
     * @return the distance between the provided coordinates
     */
    double getDistance(String lat1, String lon1, String lat2, String lon2);

}
