package dev.samuel.mechanicflow.model;

import dev.samuel.mechanicflow.enums.ServiceOrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

import java.util.UUID;

@Entity
@Table(name = "service_orders")
@Data
@NoArgsConstructor
public class ServiceOrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Description is required")
    private String description;

    @Min(value = 0, message = "Price must be valid")
    private Long totalPriceInCents = 0;

    @Enumerated(EnumType.STRING)
    private ServiceOrderStatus status = ServiceOrderStatus.OPEN;

    @CreationTimestamp
    @Column(name = "entry_date", nullable = false)
    private LocalDateTime entryDate ;

    @Column(name = "exit_date")
    private LocalDateTime exitDate = null;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private VehicleModel vehicle;
}
