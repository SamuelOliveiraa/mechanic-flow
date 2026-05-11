package dev.samuel.mechanicflow.services;

import java.util.List;

public class ServiceOrderService {
    private final ServiceOrderRepository serviceOrderRepository;

    public ServiceOrderService(ServiceOrderRepository ServiceOrderRepository) {
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
    public void delete(UUID service_order_id){
        return serviceOrderRepository.deleteById(service_order_id)
    }
}
