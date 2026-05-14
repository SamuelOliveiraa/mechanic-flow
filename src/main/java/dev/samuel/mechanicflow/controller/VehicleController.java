package dev.samuel.mechanicflow.controller;

import dev.samuel.mechanicflow.dto.VehiclePostDTO;
import dev.samuel.mechanicflow.model.VehicleModel;
import dev.samuel.mechanicflow.services.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    public VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<VehicleModel> getAll(){ return vehicleService.getAll(); }

    @PostMapping
    public List<VehicleModel> save(@RequestBody VehiclePostDTO vehicle){ return vehicleService.save(vehicle); }

    @DeleteMapping("/{vehicle_id}")
    public void delete(@PathVariable UUID vehicle_id){ vehicleService.delete(vehicle_id); }

    @PutMapping("/{vehicle_id}")
    public VehicleModel delete(@PathVariable UUID vehicle_id, @RequestBody VehicleModel vehicle){
        return vehicleService.update(vehicle_id, vehicle);
    }

}
