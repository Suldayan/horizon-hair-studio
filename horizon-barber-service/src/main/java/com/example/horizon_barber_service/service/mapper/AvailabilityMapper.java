package com.example.horizon_barber_service.service.mapper;

import com.example.horizon_barber_service.model.Availability;
import com.example.horizon_barber_service.service.dto.AvailabilityDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AvailabilityMapper {
    AvailabilityMapper INSTANCE = Mappers.getMapper(AvailabilityMapper.class);

    AvailabilityDetails availabilityToAvailabilityDTO(Availability availability);

    Availability availabilityDTOToAvailability(AvailabilityDetails availabilityDetails);
}
