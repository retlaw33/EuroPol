package com.rekeningrijden.europol;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StolenVehicle {
    @Id
    private String hashedLicensePlate;
    private String trackerId;
    private String originCountry;

    public StolenVehicle() {
    }

    public StolenVehicle(String hashedLicensePlate, String trackerId, String originCountry) {
        this.hashedLicensePlate = hashedLicensePlate;
        this.trackerId = trackerId;
        this.originCountry = originCountry;
    }

    public String getHashedLicensePlate() {
        return hashedLicensePlate;
    }

    public void setHashedLicensePlate(String hashedLicensePlate) {
        this.hashedLicensePlate = hashedLicensePlate;
    }

    public String getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(String trackerId) {
        this.trackerId = trackerId;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }
}
