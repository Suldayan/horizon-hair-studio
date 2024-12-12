package com.example.horizon_barber_service.service.impl;

import com.example.horizon_barber_service.model.Availability;
import com.example.horizon_barber_service.model.Barber;
import com.example.horizon_barber_service.model.Schedule;
import com.example.horizon_barber_service.repository.AvailabilityRepository;
import com.example.horizon_barber_service.repository.ScheduleRepository;
import com.example.horizon_barber_service.service.ScheduleManagementService;
import com.example.horizon_barber_service.service.exception.ScheduleManagementException;
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
        log.info("A new schedule: {} has been successfully created", schedule);
        return scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(Schedule schedule) throws ScheduleManagementException {
        if (!scheduleRepository.existsById(schedule.getBarberId())) {
            throw new ScheduleManagementException(
                    String.format("Failed to delete schedule: %s but expected it to exist", schedule));
        }
        log.info("Deleting schedule: {}", schedule);
        scheduleRepository.delete(schedule);
    }

    @Override
    public Availability createNewAvailability(
            LocalTime startTime,
            LocalTime endTime) {
        // Check if the availability already exists
        if (availabilityRepository.existsByStartTime(startTime)) {
            // For now, return null
            log.error("The availability with time slot: {} already exists", startTime);
            return null;
        }
        Availability availability = new Availability();
        availability.setStartTime(startTime);
        availability.setEndTime(endTime);
        availability.setIsBooked(false);
        log.info("A new availability: {} has been created", availability);
        return availabilityRepository.save(availability);
    }

    @Override
    public void deleteAvailabilityByStartTime(Availability availability) {
        if (!availabilityRepository.existsByStartTime(availability.getStartTime())) {
            log.error("The time slot: {} does not exist", availability.getStartTime());
            return;
        }
        log.info("The availability slot: {} is successfully deleted", availability);
        availabilityRepository.delete(availability);
    }

    private List<Availability> getAvailabilitySet() {
        return availabilityRepository.findAll();
    }

    private List<Schedule> getSchedule() {
        return scheduleRepository.findAll();
    }
}
