package com.example.horizon_barber_service.service.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class AvailabilityDetails {
    private String id;

    private LocalTime startTime;

    private LocalTime endTime;

    private Boolean isBooked;
}
