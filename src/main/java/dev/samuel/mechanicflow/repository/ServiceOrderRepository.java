package dev.samuel.mechanicflow.repository;

import dev.samuel.mechanicflow.model.ServiceOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrderModel, UUID> {
}
