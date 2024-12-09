package com.example.horizon_barber_service.service.mapper;

import com.example.horizon_barber_service.service.dto.BarberDetails;
import com.example.horizon_barber_service.model.Barber;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BarberMapper {
    BarberMapper INSTANCE = Mappers.getMapper(BarberMapper.class);

    BarberDetails barberToBarberDTO(Barber barber);

    Barber barberDTOToBarber(BarberDetails barberDetails);
}
