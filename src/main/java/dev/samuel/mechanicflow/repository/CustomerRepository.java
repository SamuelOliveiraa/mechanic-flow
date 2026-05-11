package dev.samuel.mechanicflow.repository;

import dev.samuel.mechanicflow.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerModel, UUID> {
}
