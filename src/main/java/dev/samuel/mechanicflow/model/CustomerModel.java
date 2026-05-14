package dev.samuel.mechanicflow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;


import java.util.UUID;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor 
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Name is required")
    private String name;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Phone is required")
    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<VehicleModel> vehicles;
}
