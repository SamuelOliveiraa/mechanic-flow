package dev.samuel.mechanicflow.services;

import dev.samuel.mechanicflow.model.VehicleModel;
import dev.samuel.mechanicflow.repository.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // GET
    public List<VehicleModel> getAll(){
        return vehicleRepository.findAll();
    }

    // POST
    public VehicleModel save(VehicleModel vehicle){
        return vehicleRepository.save(vehicle);
    }

    // DELETE
    public List<VehicleModel> delete(UUID vehicle_id) {
        if(!vehicleRepository.existsById(vehicle_id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Vehicle was not found!");
        }

        vehicleRepository.deleteById(vehicle_id);
        return getAll();
    }
}
