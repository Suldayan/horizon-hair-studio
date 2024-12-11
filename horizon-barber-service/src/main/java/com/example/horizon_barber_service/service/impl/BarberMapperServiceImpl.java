package com.example.horizon_barber_service.service.impl;

import com.example.horizon_barber_service.model.Barber;
import com.example.horizon_barber_service.repository.BarberRepository;
import com.example.horizon_barber_service.service.dto.BarberDetails;
import com.example.horizon_barber_service.service.mapper.BarberMapper;
import com.example.horizon_barber_service.service.mapper.BarberMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarberMapperServiceImpl implements BarberMapperService {
    private final BarberMapper barberMapper = BarberMapper.INSTANCE;

    @Override
    public BarberDetails entityToDto(Barber barber) {
        return barberMapper.barberToBarberDTO(barber);
    }

    @Override
    public Barber dtoToEntity(BarberDetails dto) {
        return barberMapper.barberDTOToBarber(dto);
    }
}
