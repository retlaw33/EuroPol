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
    public @ResponseBody VehicleDto getVehicle(@RequestParam String hashedLicensePlate){
        VehicleDto dto = null;
        for (StolenVehicle sv : stolenVehicleRepository.findAll()){
            if (sv.getHashedLicensePlate() == hashedLicensePlate)
                dto = vehicleMapper.VehicleToDto(sv);
        }
        return dto;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<VehicleDto> getAllStolenVehicles() {
        List<VehicleDto> dtos = new ArrayList<>();
        for (StolenVehicle sv : stolenVehicleRepository.findAll()){
            dtos.add(vehicleMapper.VehicleToDto(sv));
        }
        return dtos;
    }

    @PostMapping(path="/add")
    public void addVehicle(VehicleDto dto) {
        StolenVehicle vehicle =  vehicleMapper.DtoToNewStolenVehicle(dto);
        stolenVehicleRepository.save(vehicle);
    }

    @DeleteMapping(path="/delete")
    public void deleteVehicle(VehicleDto dto) {

    }
}
