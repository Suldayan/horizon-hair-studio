package com.example.horizonhairstudio_appointment_service.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private Long id;

    private Customer customer;
    private TimeSlot timeSlot;
}
