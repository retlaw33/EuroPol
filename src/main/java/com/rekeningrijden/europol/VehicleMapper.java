package com.rekeningrijden.europol;

import com.rekeningrijden.europe.dtos.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class VehicleMapper {
    @Autowired
    private StolenVehicleRepository stolenVehicleRepository;

    public VehicleDto VehicleToDto(StolenVehicle vehicle){
        return new VehicleDto(vehicle.getHashedLicensePlate(), vehicle.getTrackerId(), vehicle.getOriginCountry(), new ArrayList<>(), new ArrayList<>(), "", "");
    }

    public StolenVehicle DtoToNewStolenVehicle(VehicleDto dto){
        return new StolenVehicle(dto.getHashedLicensePlate(), dto.getSerialNumber(), dto.getOriginCountry());
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
