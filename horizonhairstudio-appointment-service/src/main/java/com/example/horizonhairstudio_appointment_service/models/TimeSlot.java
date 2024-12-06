package com.example.horizonhairstudio_appointment_service.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;


@Entity
@Data
@Table(name = "time_slot")
public class TimeSlot {
    @Id
    private Long client_id;

    private LocalTime startTime;
    private LocalTime endTime;
    private boolean isAvailable;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Customer customer;
}
