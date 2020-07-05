package com.demo.airlineservice.service.impl;

import com.demo.airlineservice.exception.NotFoundEntityException;
import com.demo.airlineservice.mapper.AirportMapper;
import com.demo.airlineservice.model.dto.request.AirportRequest;
import com.demo.airlineservice.model.dto.response.AirportResponse;
import com.demo.airlineservice.model.entity.Airport;
import com.demo.airlineservice.repository.AirportRepository;
import com.demo.airlineservice.service.AirportService;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {

    private final String NOT_FOUND = "Entity not found!";

    private final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public AirportResponse retrieveAirportInfoById(long id) {
        return airportRepository.findById(id)
                .map(AirportMapper::entityToResponse)
                .orElseThrow(() -> new NotFoundEntityException(NOT_FOUND));
    }

    @Override
    public AirportResponse generateAirport(AirportRequest airportRequest) {
        Airport airport = airportRepository.save(AirportMapper.requestToEntity(airportRequest));
        return AirportMapper.entityToResponse(airport);
    }
}
