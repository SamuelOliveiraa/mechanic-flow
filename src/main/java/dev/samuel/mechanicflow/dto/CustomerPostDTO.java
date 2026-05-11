package dev.samuel.mechanicflow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerPostDTO(
        @NotBlank(message = "Name is required")
        @Size(min = 3, max = 100)
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email address")
        String email,

        @NotBlank(message = "Phone is required")
        String phone) {
}
