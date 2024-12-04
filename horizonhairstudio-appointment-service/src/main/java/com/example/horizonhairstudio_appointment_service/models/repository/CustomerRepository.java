package com.example.horizonhairstudio_appointment_service.models.repository;

import com.example.horizonhairstudio_appointment_service.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
