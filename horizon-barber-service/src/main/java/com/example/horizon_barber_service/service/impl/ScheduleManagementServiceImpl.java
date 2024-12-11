package com.example.horizon_barber_service.service.impl;

import com.example.horizon_barber_service.model.Availability;
import com.example.horizon_barber_service.model.Barber;
import com.example.horizon_barber_service.model.Schedule;
import com.example.horizon_barber_service.repository.AvailabilityRepository;
import com.example.horizon_barber_service.repository.ScheduleRepository;
import com.example.horizon_barber_service.service.ScheduleManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleManagementServiceImpl implements ScheduleManagementService {
    private final ScheduleRepository scheduleRepository;
    private final AvailabilityRepository availabilityRepository;

    @Override
    public Schedule createNewSchedule(
            Barber barber,
            LocalDate date,
            Set<Availability> availabilities) {
        Schedule schedule = new Schedule();
        schedule.setBarberId(String.valueOf(barber.getId()));
        schedule.setDate(date);
        schedule.setAvailability(availabilities);
        return schedule;
    }

    @Override
    public void deleteSchedule(Schedule schedule) {
        if (!scheduleRepository.existsById(schedule.getBarberId())) {
            log.error("This schedule does not exist in the database");
            return;
        }
        scheduleRepository.delete(schedule);
    }

    @Override
    public List<Schedule> getSchedule() {
        return scheduleRepository.findAll();
    }

    @Override
    public Availability createNewAvailability(LocalTime startTime,
                                                   LocalTime endTime) {
        Availability availability = new Availability();
        availability.setStartTime(startTime);
        availability.setEndTime(endTime);
        availability.setIsBooked(false);

        // Check if the availability already exists
        if (availabilityRepository.existsByStartTime(startTime)) {
            // For now, return null
            return null;
        }
        return availabilityRepository.save(availability);
    }

    @Override
    public void deleteAvailabilityByStartTime(Availability availability) {
        if (!availabilityRepository.existsByStartTime(availability.getStartTime())) {
            log.error("The time slot: {} does not exist", availability.getStartTime());
            return;
        }
        availabilityRepository.delete(availability);
    }

    @Override
    public List<Availability> getAvailabilitySet() {
        return availabilityRepository.findAll();
    }
}
