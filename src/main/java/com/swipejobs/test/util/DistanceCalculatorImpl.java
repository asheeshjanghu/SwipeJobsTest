package com.swipejobs.test.util;

import org.springframework.stereotype.Service;

@Service
public class DistanceCalculatorImpl implements DistanceCalculator {
    private static final int R = 6371; // Radius of the earth in km

    /**
     * calculates the distance between 2 coordinates
     *
     * @param slat1 latitude of first location
     * @param slon1 longitude of first location
     * @param slat2 latitude of second location
     * @param slon2 longitude of second location
     * @return the distance between the provided coordinates
     *
     * source : https://stackoverflow.com/questions/27928/calculate-distance-between-two-latitude-longitude-points-haversine-formula
     */
    @Override
    public double getDistance(String slat1, String slon1, String slat2, String slon2) {
        double lat1 = Double.parseDouble(slat1);
        double lon1 = Double.parseDouble(slon1);

        double lat2 = Double.parseDouble(slat2);
        double lon2 = Double.parseDouble(slon2);

        double dLat = deg2rad(lat2 - lat1);  // deg2rad below
        double dLon = deg2rad(lon2 - lon1);
        double a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c; // Distance in km
        return d;
    }

    private double deg2rad(double deg) {
        return deg * (Math.PI / 180);
    }

}
