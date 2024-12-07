package com.example.horizon_barber_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "schedules")
@Data
public class Schedule {
    @Id
    private String id;

    @NotBlank
    private String barberId;
    
    @NotNull
    private LocalDate date;

    private List<Availability> availability;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
