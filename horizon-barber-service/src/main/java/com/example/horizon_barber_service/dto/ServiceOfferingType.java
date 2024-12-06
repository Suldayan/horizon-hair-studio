package com.example.horizon_barber_service.dto;

import lombok.Data;

@Data
public class ServiceOfferingType {
    private String id;

    private String type;

    private Integer price;

    private String estimatedDuration;
}
