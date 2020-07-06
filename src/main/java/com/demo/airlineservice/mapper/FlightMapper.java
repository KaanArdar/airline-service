package com.demo.airlineservice.mapper;

import com.demo.airlineservice.model.dto.request.FlightRequest;
import com.demo.airlineservice.model.dto.request.RouteRequest;
import com.demo.airlineservice.model.dto.response.FlightResponse;
import com.demo.airlineservice.model.dto.response.RouteResponse;
import com.demo.airlineservice.model.entity.Flight;
import com.demo.airlineservice.model.entity.Route;

public class FlightMapper {

    public static Flight requestToEntity(FlightRequest request){
        return Flight.builder()
                .routeCode(request.getRouteCode())
                .availableSeat(request.getAvailableSeat())
                .flightCode(request.getFlightCode())
                .price(request.getPrice())
                .totalSeat(request.getTotalSeat())
                .build();
    }

    public static FlightResponse entityToResponse(Flight flight, Route route){
        return FlightResponse.builder().routeInfo(RouteResponse.builder()
                .id(route.getId())
                .routeCode(route.getRouteCode())
                .departure(route.getDeparture())
                .destination(route.getDestination())
                .distance(route.getDistance())
                .build())
                .flightCode(flight.getFlightCode())
                .price(flight.getPrice())
                .build();
    }

}
