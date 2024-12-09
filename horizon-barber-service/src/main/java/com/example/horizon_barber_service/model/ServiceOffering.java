package com.example.horizon_barber_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "service-offerings")
public class ServiceOffering {
    @Id
    private String id;

    @Column(name = "service-type")
    @NotBlank
    private String type;

    @Column(name = "price")
    @NotNull
    private Integer price;

    @Column(name = "duration")
    @NotBlank
    private String estimatedDuration;
}
