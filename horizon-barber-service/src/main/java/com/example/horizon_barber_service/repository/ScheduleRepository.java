package com.example.horizon_barber_service.repository;

import com.example.horizon_barber_service.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {
}
