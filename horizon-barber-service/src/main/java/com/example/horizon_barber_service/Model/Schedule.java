package com.example.horizon_barber_service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "schedules")
@Data
public class Schedule {
    @Id
    private String id;
    private String barberId;
    private LocalDate date;
    private List<Availability> availabilityList;
}
