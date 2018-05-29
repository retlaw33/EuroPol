package com.rekeningrijden.europol;

import com.rekeningrijden.europe.dtos.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/euroPolApi")
public class StolenVehicleController {
    @Autowired
    private StolenVehicleRepository stolenVehicleRepository;
    private VehicleMapper vehicleMapper;

    public StolenVehicleController() {
        this.vehicleMapper = new VehicleMapper();
    }

    @GetMapping("/test")
    public String greeting() {
        return "test";
    }

    @GetMapping("/{id}")
    public VehicleDto getVehicle(@RequestParam String hashedLicensePlate){
        StolenVehicle sv = stolenVehicleRepository.findByHashedLicensePlate(hashedLicensePlate);
        return vehicleMapper.VehicleToDto(sv);

        /*VehicleDto dto = null;
        for (StolenVehicle sv : stolenVehicleRepository.findAll()){
            if (sv.getHashedLicensePlate() == hashedLicensePlate)
                dto = vehicleMapper.VehicleToDto(sv);
        }
        return dto;*/
    }

    @GetMapping()
    public Iterable<VehicleDto> getAllStolenVehicles() {
        List<VehicleDto> dtos = new ArrayList<>();
        for (StolenVehicle sv : stolenVehicleRepository.findAll()){
            dtos.add(vehicleMapper.VehicleToDto(sv));
        }
        return dtos;
    }

    @PostMapping()
    public void addVehicle(VehicleDto dto) {
        StolenVehicle vehicle =  vehicleMapper.DtoToNewStolenVehicle(dto);
        stolenVehicleRepository.save(vehicle);
    }

    @DeleteMapping()
    public void deleteVehicle(VehicleDto dto) {
        StolenVehicle vehicle =  vehicleMapper.DtoToNewStolenVehicle(dto);
        stolenVehicleRepository.delete(vehicle);
    }
}
