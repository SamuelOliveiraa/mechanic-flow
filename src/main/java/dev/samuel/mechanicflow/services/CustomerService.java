package dev.samuel.mechanicflow.services;

import dev.samuel.mechanicflow.model.CustomerModel;
import dev.samuel.mechanicflow.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
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

        if(customer.getEmail() != null && !customer.getEmail().isEmpty()){
            existingCustomer.setEmail(customer.getEmail());
        }

        if(customer.getName() != null && !customer.getName().isEmpty()){
            existingCustomer.setName(customer.getName());
        }

        if(customer.getPhone() != null && !customer.getPhone().isEmpty()){
            existingCustomer.setPhone(customer.getPhone());
        }

        customerRepository.save(existingCustomer);
        return existingCustomer;
    }
}
