package dev.samuel.mechanicflow.services;

import dev.samuel.mechanicflow.dto.ServiceOrderPostDTO;
import dev.samuel.mechanicflow.model.ServiceOrderModel;
import dev.samuel.mechanicflow.repository.ServiceOrderRepository;
import dev.samuel.mechanicflow.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.BeanUtils;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ServiceOrderService {
    private final ServiceOrderRepository serviceOrderRepository;
    private final VehicleRepository vehicleRepository;

    // GET
    public List<ServiceOrderModel> getAll(){
        return serviceOrderRepository.findAll();
    }

    // POST
    public List<ServiceOrderModel> save(@NonNull ServiceOrderPostDTO service_order){
        var vehicle = vehicleRepository.findById(service_order.vehicle_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found"));

        ServiceOrderModel newServiceOrder = new ServiceOrderModel();

        BeanUtils.copyProperties(service_order, newServiceOrder, "id", "vehicle");
        newServiceOrder.setVehicle(vehicle);

        serviceOrderRepository.save(newServiceOrder);

        return getAll();
    }

    // DELETE
    public void delete(UUID service_order_id) {
        if(!serviceOrderRepository.existsById(service_order_id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Service order was not found!");
        }
        serviceOrderRepository.deleteById(service_order_id);
    }
}
