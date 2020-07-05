package com.demo.airlineservice.mapper;

import com.demo.airlineservice.model.dto.request.AirportRequest;
import com.demo.airlineservice.model.dto.response.AirportResponse;
import com.demo.airlineservice.model.entity.Airport;

public class AirportMapper {

    public static Airport requestToEntity(AirportRequest request){
        return Airport.builder()
                .name(request.getName())
                .city(request.getCity())
                .address(request.getAddress())
                .build();
    }

    public static AirportResponse entityToResponse(Airport airport){
        return AirportResponse.builder()
                .id(airport.getId())
                .name(airport.getName())
                .city(airport.getCity())
                .address(airport.getAddress())
                .build();
    }

}
