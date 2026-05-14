package dev.samuel.mechanicflow.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record ServiceOrderPostDTO(
        @NotBlank(message = "Description is required")
        String description,

        @Min(value = 0, message = "Price must be valid")
        Long totalPriceInCents,

        @NotBlank(message = "Vehicle ID is required")
        UUID vehicle_id
) {}
