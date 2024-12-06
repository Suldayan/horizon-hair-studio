package com.example.horizonhairstudio_appointment_service.models;

import com.example.horizonhairstudio_appointment_service.enums.Services;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
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
    @NotBlank
    private String email;

    @Column(name = "phoneNumber")
    @NotBlank
    private String phoneNumber;

    @Column(name = "service")
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Services service;

    @Column(name = "price")
    @NotBlank
    @Positive
    private int price;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TimeSlot> appointments = new HashSet<>();
}
