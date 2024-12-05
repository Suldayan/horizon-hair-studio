package com.example.horizonhairstudio_appointment_service.models;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Slf4j
@Data
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
