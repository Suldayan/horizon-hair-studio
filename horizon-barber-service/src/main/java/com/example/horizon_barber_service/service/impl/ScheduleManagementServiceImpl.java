package com.example.horizon_barber_service.service.impl;

import com.example.horizon_barber_service.model.Availability;
import com.example.horizon_barber_service.model.Barber;
import com.example.horizon_barber_service.repository.AvailabilityRepository;
import com.example.horizon_barber_service.service.ScheduleManagementService;
import com.example.horizon_barber_service.service.exception.ScheduleManagementRuntime;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleManagementServiceImpl implements ScheduleManagementService {
    private final AvailabilityRepository availabilityRepository;

    @Override
    public Availability createNewAvailability(
            @NotNull @Nonnull Barber barber,
            @NotNull @Nonnull LocalDate date,
            @NotNull @Nonnull LocalTime timeSlot) throws ScheduleManagementRuntime {

    }

    private void availabilityValidator(@NotNull @Nonnull Availability availability) {
        
    }

    private void addAvailability(Availability availability) {
        //
    }

    @Override
    public void deleteAvailabilityByStartTime(@NotNull @Nonnull Availability availability) throws ScheduleManagementRuntime {

    }

    @Override
    public Set<Availability> getAvailabilities() {
        //
    }
}
