package com.example.horizon_barber_service.service;

import com.example.horizon_barber_service.model.Barber;
import com.example.horizon_barber_service.service.dto.BarberDetails;

public interface BarberMapperService {
    BarberDetails barberToBarberDTO(Barber barber);

    Barber barberDTOToBarber(BarberDetails dto);
}
