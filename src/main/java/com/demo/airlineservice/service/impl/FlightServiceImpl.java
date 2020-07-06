package com.demo.airlineservice.service.impl;

import com.demo.airlineservice.exception.NotFoundEntityException;
import com.demo.airlineservice.mapper.FlightMapper;
import com.demo.airlineservice.model.dto.request.FlightRequest;
import com.demo.airlineservice.model.dto.response.FlightResponse;
import com.demo.airlineservice.repository.FlightRepository;
import com.demo.airlineservice.repository.RouteRepository;
import com.demo.airlineservice.service.FlightService;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    private final String ROUTE_NOT_FOUND = "Route Entity not found!";
    private final String FLIGHT_NOT_FOUND = "Route Entity not found!";


    private final RouteRepository routeRepository;
    private final FlightRepository flightRepository;

    public FlightServiceImpl(RouteRepository routeRepository, FlightRepository flightRepository) {
        this.routeRepository = routeRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public void generateFlight(FlightRequest flightRequest) {
        flightRepository.save(FlightMapper.requestToEntity(flightRequest));
    }

    @Override
    public FlightResponse retrieveFlightInfoByFlightCode(long id) {
        return flightRepository.findById(id)
                .map(flight -> routeRepository.findByRouteCode(flight.getRouteCode())
                        .map(route -> FlightMapper.entityToResponse(flight,route))
                        .orElseThrow(() -> new NotFoundEntityException(ROUTE_NOT_FOUND)))
                .orElseThrow(() -> new NotFoundEntityException(FLIGHT_NOT_FOUND));
    }

}
