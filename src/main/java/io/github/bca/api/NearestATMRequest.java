package io.github.bca.api;

import java.io.Serializable;

public class NearestATMRequest implements Serializable {

    private double latitude;

    private double longitude;

    private int radius;

    private int count = 10;

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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "NearestATMRequest{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", radius=" + radius +
                ", count=" + count +
                '}';
    }
}
