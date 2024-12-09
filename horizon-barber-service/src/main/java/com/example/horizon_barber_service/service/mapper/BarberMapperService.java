package com.example.horizon_barber_service.service.mapper;

import com.example.horizon_barber_service.model.Barber;
import com.example.horizon_barber_service.service.dto.BarberDetails;

public interface BarberMapperService {
    BarberDetails entityToDto(Barber barber);

    Barber dtoToEntity(BarberDetails dto);
}
