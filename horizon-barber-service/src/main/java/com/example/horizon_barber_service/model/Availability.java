package com.example.horizon_barber_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "availability")
@Data
public class Availability {
    @Id
    private String id;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @Column(name = "startTime")
    @NotNull
    private LocalTime startTime;

    @Column(name = "endTime")
    @NotNull
    private LocalTime endTime;

    @Column(name = "isBooked")
    @NotNull
    private Boolean isBooked;
}
