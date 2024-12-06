package com.example.horizonhairstudio_appointment_service.controller.api.v1;

import com.example.horizonhairstudio_appointment_service.enums.Services;
import com.example.horizonhairstudio_appointment_service.models.Appointment;
import com.example.horizonhairstudio_appointment_service.models.Customer;
import com.example.horizonhairstudio_appointment_service.models.TimeSlot;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/appointment")
@Slf4j
public class AppointmentController {

    private final String success = "Appointment successfully made!";
    private final String failure = "Failed to book your appointment";

    @PostMapping("/book")
    public String setAppointment(
            @NotBlank String name,
            @NotBlank @Email String email,
            @NotBlank String phoneNumber,
            @NotBlank String service,
            @Positive int price,
            @NotNull LocalTime startTime,
            @NotNull LocalTime endTime
    ) {
        TimeSlot requestedTime = createTimeSlot(startTime, endTime);
        if (isTimeSlotAvailable(requestedTime)) {
            log.info("The current timeslot is unavailable");
            return null;
        }
        Customer customer = createCustomer(name, email, phoneNumber, service, price);
        try {
            log.debug("Attempting to create appointment");
            createAppointment(customer, requestedTime);
        } catch (Exception e) {
            log.error("{}: {}", failure, e.getMessage());
        }
        return success;
    }

    @PutMapping("/update")
    public void updateAppointmentTime(
            @NotBlank @Email String email,
            @NotNull LocalTime newStartTime,
            @NotNull LocalTime newEndTime
    ) {
        //
    }

    @DeleteMapping("/remove")
    public void cancelAppointment(
            @NotBlank @Email String email
    ) {
        // Implementation logic here
    }

    private Customer createCustomer(
            @NotBlank String name,
            @NotBlank @Email String email,
            @NotBlank String phoneNumber,
            @NotBlank String service,
            @Positive int price) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setService(Services.valueOf(service));

        return customer;
    }

    private TimeSlot createTimeSlot(
            @NotNull LocalTime startTime,
            @NotNull LocalTime endTime
    ) {
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setStartTime(startTime);
        timeSlot.setEndTime(endTime);

        return timeSlot;
    }

    private Appointment createAppointment(Customer customer, TimeSlot timeSlot) {
        Appointment appointment = new Appointment();
        appointment.setCustomer(customer);
        appointment.setTimeSlot(timeSlot);

        return appointment;
    }

    private Boolean isTimeSlotAvailable(TimeSlot timeSlot) {
        return !(timeSlot.isAvailable());
    }
}
