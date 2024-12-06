package com.example.horizon_barber_service.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service-offerings")
public class ServiceOffering {
    @Id
    private String id;

    @Column(name = "service-type")
    private String type;

    @Column(name = "price")
    private Integer price;

    @Column(name = "duration")
    private String estimatedDuration;
}
