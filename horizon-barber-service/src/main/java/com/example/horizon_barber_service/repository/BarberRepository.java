package com.example.horizon_barber_service.repository;

import com.example.horizon_barber_service.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber ,Long> {

}
