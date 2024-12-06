package com.example.horizon_barber_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "service-offerings")
public class ServiceOffering {
    @Id
    private String id;

    @Column(name = "service-type")
    private String type;

    @Column(name = "price")
    private Integer price;

    @Column(name = "duration")
    private String estimatedDuration;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
