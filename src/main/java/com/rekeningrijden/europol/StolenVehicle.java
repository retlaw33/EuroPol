package com.rekeningrijden.europol;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StolenVehicle {
    @Id
    private String HashedLicensePlate;

    public StolenVehicle() {
    }

    public StolenVehicle(String hashedLicensePlate) {
        HashedLicensePlate = hashedLicensePlate;
    }

    public String getHashedLicensePlate() {
        return HashedLicensePlate;
    }
}
