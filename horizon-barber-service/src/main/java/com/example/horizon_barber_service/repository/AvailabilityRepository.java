package com.example.horizon_barber_service.repository;

import com.example.horizon_barber_service.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;

public interface AvailabilityRepository extends JpaRepository<Availability, String> {
    boolean existsByStartTime(LocalTime startTime);
}
