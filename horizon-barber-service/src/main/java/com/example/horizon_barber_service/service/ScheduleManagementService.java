package com.example.horizon_barber_service.service;

import com.example.horizon_barber_service.model.Availability;
import com.example.horizon_barber_service.model.Barber;
import com.example.horizon_barber_service.service.exception.ScheduleManagementRuntime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public interface ScheduleManagementService {

    Availability createNewAvailability(
            Barber barber,
            LocalDate date,
            LocalTime timeSlot
    ) throws ScheduleManagementRuntime;

    void deleteAvailabilityByStartTime(Availability availability) throws ScheduleManagementRuntime;

    Set<Availability> getAvailabilities();
}
