package dev.samuel.mechanicflow.controller;

import dev.samuel.mechanicflow.model.CustomerModel;
import dev.samuel.mechanicflow.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerModel> getAll() {
        return customerService.getAll();
    }

    @PostMapping
    public CustomerModel save(@RequestBody CustomerModel customer){
        return customerService.save(customer);
    }

    @DeleteMapping("/{customer_id}")
    public void delete(@PathVariable UUID customer_id){
        customerService.delete(customer_id);
    }


    @PutMapping("/{customer_id}")
    public CustomerModel update(@PathVariable UUID customer_id,@RequestBody CustomerModel customer){
        return customerService.update(customer_id, customer);
    }

}
