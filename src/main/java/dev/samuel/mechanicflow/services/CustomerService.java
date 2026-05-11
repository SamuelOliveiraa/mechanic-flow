package dev.samuel.mechanicflow.services;

import dev.samuel.mechanicflow.dto.CustomerPostDTO;
import dev.samuel.mechanicflow.model.CustomerModel;
import dev.samuel.mechanicflow.repository.CustomerRepository;
import java.util.List;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // GET
    public List<CustomerModel> getAll(){
        return customerRepository.findAll();
    }

    // POST
    public CustomerModel save(CustomerModel customer){
        return customerRepository.save(customer);
    }
}
