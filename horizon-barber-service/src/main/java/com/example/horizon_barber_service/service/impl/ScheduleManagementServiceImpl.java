package com.example.horizon_barber_service.service.impl;

import com.example.horizon_barber_service.model.Availability;
import com.example.horizon_barber_service.repository.AvailabilityRepository;
import com.example.horizon_barber_service.service.ScheduleManagementService;
import com.example.horizon_barber_service.service.exception.ScheduleManagementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleManagementServiceImpl implements ScheduleManagementService {
    private final AvailabilityRepository availabilityRepository;

    @Override
    public Availability createNewAvailability(
            LocalTime startTime,
            LocalTime endTime) throws ScheduleManagementException {
        // Check if the availability already exists
        if (availabilityRepository.existsByStartTime(startTime)) {
            throw new ScheduleManagementException(String.format("An availability of this time: %s already exists", startTime));
        }
        if (availabilityRepository.existsByEndTime(endTime)) {
            throw new ScheduleManagementException(String.format("An availability of this time: %s already exists", endTime));
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

    @Override
    public List<Availability> getAvailabilities() {
        return availabilityRepository.findAll();
    }
}
