package dev.samuel.mechanicflow.services;

import dev.samuel.mechanicflow.dto.VehiclePostDTO;
import dev.samuel.mechanicflow.model.VehicleModel;
import dev.samuel.mechanicflow.repository.CustomerRepository;
import dev.samuel.mechanicflow.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.BeanUtils;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;

    // GET
    public List<VehicleModel> getAll(){
        return vehicleRepository.findAll();
    }

    // POST
    public List<VehicleModel> save(VehiclePostDTO vehicle) {
        var customer = customerRepository.findById(vehicle.customer_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customner not found"));

        VehicleModel newVehicle = new VehicleModel();

        BeanUtils.copyProperties(vehicle, newVehicle);
        newVehicle.setCustomer(customer);

        vehicleRepository.save(newVehicle);
        return getAll();
    }

    // DELETE
    public void delete(UUID vehicle_id) {
        if(!vehicleRepository.existsById(vehicle_id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Vehicle was not found!");
        }
        vehicleRepository.deleteById(vehicle_id);
    }

    // PUT
    public VehicleModel update(UUID vehicle_id, VehicleModel vehicle) {
        VehicleModel existingVehicle = vehicleRepository.findById(vehicle_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found"));

       BeanUtils.copyProperties(vehicle, existingVehicle, "id", "customer");

        return vehicleRepository.save(existingVehicle);
    }
}
