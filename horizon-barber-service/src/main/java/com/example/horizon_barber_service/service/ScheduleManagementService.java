package com.example.horizon_barber_service.service;

import com.example.horizon_barber_service.model.Availability;
import com.example.horizon_barber_service.service.exception.ScheduleManagementException;

import java.time.LocalTime;
import java.util.List;

public interface ScheduleManagementService {

    Availability createNewAvailability(
            LocalTime startTime,
            LocalTime endTime
    ) throws ScheduleManagementException ;

    void deleteAvailabilityByStartTime(Availability availability);

    List<Availability> getAvailabilities();
}
