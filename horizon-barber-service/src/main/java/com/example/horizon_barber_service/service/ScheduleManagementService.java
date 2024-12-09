package com.example.horizon_barber_service.service;

import com.example.horizon_barber_service.service.dto.AvailabilityDetails;
import com.example.horizon_barber_service.service.dto.BarberDetails;
import com.example.horizon_barber_service.service.dto.ScheduleDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleManagementService {
    private final ScheduleDetails schedule;
    private final AvailabilityDetails availability;
    private final BarberDetails barber;

}
