package com.example.horizon_barber_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "availability")
@Data
public class Availability {
    @Id
    private String id;

    @Column(name = "startTime")
    @NotBlank
    private LocalTime startTime;

    @Column(name = "endTime")
    private LocalTime endTime;

    @Column(name = "isBooked")
    private Boolean isBooked;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
