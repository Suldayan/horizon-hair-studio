package com.example.horizon_barber_service.service.impl;

import com.example.horizon_barber_service.model.Availability;
import com.example.horizon_barber_service.model.Barber;
import com.example.horizon_barber_service.service.ScheduleManagementService;
import com.example.horizon_barber_service.service.exception.ScheduleManagementRuntime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleManagementServiceImpl implements ScheduleManagementService {
    private static final Set<Availability> availabilities = new HashSet<>();

    @Override
    public Availability createNewAvailability(
            Barber barber,
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime) throws ScheduleManagementRuntime {
        // Check if the availability already exists
        availabilities.forEach(availability -> {
            if (availability.getStartTime() == startTime) {
                throw new ScheduleManagementRuntime(String.format("The start time: %s already exists", startTime));
            }
            if (availability.getEndTime() == endTime) {
                throw new ScheduleManagementRuntime(String.format("The end time: %s already exists", endTime));
            }
        });
        Availability availability = new Availability();
        availability.setId(String.valueOf(barber.getId()));
        availability.setDate(date);
        availability.setStartTime(startTime);
        availability.setEndTime(endTime);
        availability.setIsBooked(false);
        // Add the availability to the set
        addAvailability(availability);
        log.info("A new availability: {} has been created", availability);
        return availability;
    }

    private void addAvailability(Availability availability) {
        availabilities.add(availability);
    }

    @Override
    public void deleteAvailabilityByStartTime(Availability availability) throws ScheduleManagementRuntime {
        availabilities.forEach(timeslot -> {
            if (availability.getStartTime() == timeslot.getStartTime()) {
                log.info("Successfully deleted timeslot: {}", availability.getStartTime());
                availabilities.remove(timeslot);
            }
            throw new ScheduleManagementRuntime(String.format("The timeslot %s does not exist", timeslot.getStartTime()));
        });
    }

    @Override
    public Set<Availability> getAvailabilities() {
        return availabilities;
    }
}
