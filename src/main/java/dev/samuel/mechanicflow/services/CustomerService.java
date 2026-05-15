package dev.samuel.mechanicflow.services;

import dev.samuel.mechanicflow.model.CustomerModel;
import dev.samuel.mechanicflow.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    // GET
    public List<CustomerModel> getAll(){
        return customerRepository.findAll();
    }

    // POST
    public CustomerModel save(CustomerModel customer){
        return customerRepository.save(customer);
    }

    // DELETE
    public void delete(UUID customer_id) {
        if(!customerRepository.existsById(customer_id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Customer was not found!");
        }

        customerRepository.deleteById(customer_id);
    }


    public CustomerModel update(UUID customer_id, CustomerModel customer){
        CustomerModel existingCustomer = customerRepository.findById(customer_id)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found!"));

        BeanUtils.copyProperties(customer, existingCustomer, "id", "vehicles");

        customerRepository.save(existingCustomer);
        return existingCustomer;
    }
}
