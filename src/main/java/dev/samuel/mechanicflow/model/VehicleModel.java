package dev.samuel.mechanicflow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vehicles")
@Data
@NoArgsConstructor
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "License plate is required")
    @Column(nullable = false, unique = true)
    private String licensePlate;

    @NotBlank(message = "Model vehicle is required")
    @Column(nullable = false)
    private String model;

    @NotBlank(message = "Brand vehicle is required")
    @Column(nullable = false)
    private String brand;

    @Min(value = 1900, message = "Year must be valid")
    @Column(name = "manufacture_year")
    private int year;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnore
    private CustomerModel customer;

    @OneToMany(mappedBy = "vehicle")
    @JsonIgnore
    private List<ServiceOrderModel> service_orders;
}
