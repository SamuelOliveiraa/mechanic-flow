package dev.samuel.mechanicflow.repository;

import dev.samuel.mechanicflow.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleRepository extends JpaRepository<VehicleModel, UUID> {
}
