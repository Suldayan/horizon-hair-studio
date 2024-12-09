package com.example.horizon_barber_service.model;

import jakarta.persistence.*;
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

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "schedule")
    private List<Availability> availability;

}
