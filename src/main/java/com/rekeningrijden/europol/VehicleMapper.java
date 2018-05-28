package com.rekeningrijden.europol;

import com.rekeningrijden.europe.dtos.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleMapper {
    @Autowired
    private StolenVehicleRepository stolenVehicleRepository;

    public VehicleDto VehicleToDto(StolenVehicle vehicle){
        return new VehicleDto(vehicle.getHashedLicensePlate(), null, null);
    }

    public StolenVehicle DtoToNewStolenVehicle(VehicleDto dto){
        return new StolenVehicle(dto.getHashedLicensePlate());
    }

    public StolenVehicle DtoToExistingVehicle(VehicleDto dto){
        for (StolenVehicle sv : stolenVehicleRepository.findAll()){
            if (dto.getHashedLicensePlate().equals(sv.getHashedLicensePlate())){
                return sv;
            }
        }
        return null;
    }
}
