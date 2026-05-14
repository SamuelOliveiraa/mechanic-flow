package dev.samuel.mechanicflow.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record VehiclePostDTO(
        @NotBlank(message = "Customer ID is required")
        UUID customer_id,

        @NotBlank(message = "License plate is required")
        String licensePlate,

        @NotBlank(message = "Model vehicle is required")
        String model,

        @NotBlank(message = "Brand vehicle is required")
        String brand,

        @Min(value = 1900, message = "Year must be valid")
        int year
) {}
