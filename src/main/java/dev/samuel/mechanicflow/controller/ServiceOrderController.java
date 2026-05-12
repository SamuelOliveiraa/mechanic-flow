package dev.samuel.mechanicflow.controller;

import dev.samuel.mechanicflow.model.ServiceOrderModel;
import dev.samuel.mechanicflow.services.ServiceOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/service_order")
public class ServiceOrderController {
    public ServiceOrderService serviceOrderService;

    public ServiceOrderController(ServiceOrderService serviceOrderService) {
        this.serviceOrderService = serviceOrderService;
    }

    @GetMapping
    public List<ServiceOrderModel> getAll(){ return serviceOrderService.getAll(); }

    @PutMapping
    public ServiceOrderModel save(@RequestBody ServiceOrderModel service_order){ return serviceOrderService.save(service_order); }

    @DeleteMapping("/{service_order_id}")
    public void delete(@PathVariable UUID service_order_id){
        serviceOrderService.delete(service_order_id);
    }
}
