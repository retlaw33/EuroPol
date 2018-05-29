package com.rekeningrijden.europol;

import org.springframework.data.repository.CrudRepository;

public interface StolenVehicleRepository extends CrudRepository<StolenVehicle, Long> {
    StolenVehicle findByHashedLicensePlate(String hashedLicensePlate);
}

