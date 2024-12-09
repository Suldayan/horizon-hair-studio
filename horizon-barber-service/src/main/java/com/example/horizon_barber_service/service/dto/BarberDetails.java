package com.example.horizon_barber_service.service.dto;

import com.example.horizon_barber_service.model.ServiceOffering;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class BarberDetails {
    private String name;

    private String email;

    private String phoneNumber;

    private final Set<ServiceOffering> services = new HashSet<>();
}
