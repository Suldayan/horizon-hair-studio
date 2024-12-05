package com.example.horizonhairstudio_appointment_service.models;

import com.example.horizonhairstudio_appointment_service.enums.Services;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "client")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "email")
    @Nullable
    private String email;

    @Column(name = "phoneNumber")
    @Nullable
    private String phoneNumber;

    @Column(name = "service")
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Services service;

    @Column(name = "price")
    @NotBlank
    private int price;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TimeSlot> appointments = new HashSet<>();
}
