package com.example.horizonhairstudio_appointment_service.models;

import com.example.horizonhairstudio_appointment_service.enums.Services;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

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
}
