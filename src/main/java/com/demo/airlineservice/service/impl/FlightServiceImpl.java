package com.demo.airlineservice.service.impl;

import com.demo.airlineservice.exception.NotFoundEntityException;
import com.demo.airlineservice.mapper.FlightMapper;
import com.demo.airlineservice.model.dto.request.FlightRequest;
import com.demo.airlineservice.model.dto.response.FlightResponse;
import com.demo.airlineservice.repository.FlightRepository;
import com.demo.airlineservice.repository.RouteRepository;
import com.demo.airlineservice.service.FlightService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
    public FlightResponse retrieveFlightInfoByFlightId(long id) {
        return flightRepository.findById(id)
                .map(flight -> routeRepository.findByRouteCode(flight.getRouteCode())
                        .map(route -> FlightMapper.entityToResponse(flight,route))
                        .orElseThrow(() -> new NotFoundEntityException(ROUTE_NOT_FOUND)))
                .orElseThrow(() -> new NotFoundEntityException(FLIGHT_NOT_FOUND));
    }

    @Override
    public void updateAvailableSeat(long flightId) {
        flightRepository.findById(flightId)
                .map(flight -> {
                    int availableSeat = flight.getAvailableSeat() - 1;
                    BigDecimal price = calculatePrice(availableSeat, flight.getTotalSeat(), flight.getPrice());
                    flightRepository.updateAvailableSeat(flightId, availableSeat, price);
                    return true;
                })
                .orElseThrow(() -> new NotFoundEntityException(FLIGHT_NOT_FOUND));
    }

    public BigDecimal calculatePrice(int availableSeat, int totalSeat, BigDecimal price){
        int purchasedSeat = totalSeat - availableSeat;

        BigDecimal newPrice = price.add(price.multiply(new BigDecimal("0.1")));

        if(purchasedSeat >= totalSeat * 0.1 && purchasedSeat < totalSeat * 0.2){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.2 && purchasedSeat < totalSeat * 0.3){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.3 && purchasedSeat < totalSeat * 0.4){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.4 && purchasedSeat < totalSeat * 0.5){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.5 && purchasedSeat < totalSeat * 0.6){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.6 && purchasedSeat < totalSeat * 0.7){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.7 && purchasedSeat < totalSeat * 0.8){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.8 && purchasedSeat < totalSeat * 0.9){
            return newPrice;
        }else if(purchasedSeat >= totalSeat * 0.9){
            return newPrice;
        }else{
            return price ;
        }
    }


}
