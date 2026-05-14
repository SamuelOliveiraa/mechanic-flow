package dev.samuel.mechanicflow.controller;

import dev.samuel.mechanicflow.dto.ServiceOrderPostDTO;
import dev.samuel.mechanicflow.model.ServiceOrderModel;
import dev.samuel.mechanicflow.services.ServiceOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/service_orders")
public class ServiceOrderController {
    public ServiceOrderService serviceOrderService;

    public ServiceOrderController(ServiceOrderService serviceOrderService) {
        this.serviceOrderService = serviceOrderService;
    }

    @GetMapping
    public List<ServiceOrderModel> getAll(){ return serviceOrderService.getAll(); }

    @PostMapping
    public List<ServiceOrderModel> save(@RequestBody ServiceOrderPostDTO service_order){ return serviceOrderService.save(service_order); }

    @DeleteMapping("/{service_order_id}")
    public void delete(@PathVariable UUID service_order_id){
        serviceOrderService.delete(service_order_id);
    }
}
