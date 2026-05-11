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

    private String description;

    private Long totalPriceInCents;

    @Enumerated(EnumType.STRING)
    private ServiceOrderStatus status = ServiceOrderStatus.OPEN;

    @CreationTimestamp
    @Column(name = "entry_date", nullable = false)
    private LocalDateTime entry_date;

    private LocalDateTime exit_date;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private VehicleModel vehicle;
}
