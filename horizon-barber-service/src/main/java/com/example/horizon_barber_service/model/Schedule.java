package com.example.horizon_barber_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "schedules")
@Data
public class Schedule {
    @Id
    @NotBlank
    private String barberId;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "schedule")
    private Set<Availability> availability;
}
