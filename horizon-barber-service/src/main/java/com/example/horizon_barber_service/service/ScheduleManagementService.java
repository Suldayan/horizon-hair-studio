package com.example.horizon_barber_service.service;

import com.example.horizon_barber_service.model.Availability;
import com.example.horizon_barber_service.model.Barber;
import com.example.horizon_barber_service.model.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

public interface ScheduleManagementService {
    Schedule createNewSchedule(
            Barber barber,
            LocalDate date,
            Set<Availability> availabilities
    );

    void deleteSchedule(Schedule schedule);

    List<Schedule> getSchedule();

    Availability createNewAvailability(
            LocalTime startTime,
            LocalTime endTime
    );

    void deleteAvailabilityByStartTime(Availability availability);

    List<Availability> getAvailabilitySet();
}
