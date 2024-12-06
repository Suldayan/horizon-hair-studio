package com.example.horizon_barber_service.dto;

import com.example.horizon_barber_service.model.Availability;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ScheduleDetails {
    private String id;

    private String barberId;

    private LocalDateTime date;

    private List<Availability> availability = new ArrayList<>();
}
