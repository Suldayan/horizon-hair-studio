package com.example.horizon_barber_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "barbers")
@Data
public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "email")
    @NotBlank
    private String email;

    @Column(name = "phoneNumber")
    @NotNull
    @Digits(fraction = 0, integer = 12)
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "barber")
    private Set<ServiceOffering> services;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "barber")
    private Schedule schedule;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
