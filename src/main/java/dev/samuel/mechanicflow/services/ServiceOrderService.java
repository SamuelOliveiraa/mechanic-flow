package dev.samuel.mechanicflow.services;

import dev.samuel.mechanicflow.model.ServiceOrderModel;
import dev.samuel.mechanicflow.repository.ServiceOrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceOrderService {
    private final ServiceOrderRepository serviceOrderRepository;

    public ServiceOrderService(ServiceOrderRepository serviceOrderRepository) {
        this.serviceOrderRepository = serviceOrderRepository;
    }

    // GET
    public List<ServiceOrderModel> getAll(){
        return serviceOrderRepository.findAll();
    }

    // POST
    public ServiceOrderModel save(ServiceOrderModel service_order){
        return serviceOrderRepository.save(service_order);
    }

    // DELETE
    public List<ServiceOrderModel> delete(UUID service_order_id) {
        if(!serviceOrderRepository.existsById(service_order_id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Service order was not found!");
        }
        serviceOrderRepository.deleteById(service_order_id);
        return getAll();
    }
}
