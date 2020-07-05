package com.demo.airlineservice.mapper;

import com.demo.airlineservice.model.dto.request.AirCarrierRequest;
import com.demo.airlineservice.model.dto.response.AirCarrierResponse;
import com.demo.airlineservice.model.entity.AirCarrier;

public class AirCarrierMapper {


    public static AirCarrier requestToEntity(AirCarrierRequest request){
        return AirCarrier.builder()
                .name(request.getName())
                .aircraftNumber(request.getAircraftNumber())
                .destinationNumber(request.getDestinationNumber())
                .build();
    }

    public static AirCarrierResponse entityToResponse(AirCarrier airCarrier){
        return AirCarrierResponse.builder()
                .id(airCarrier.getId())
                .name(airCarrier.getName())
                .aircraftNumber(airCarrier.getAircraftNumber())
                .destinationNumber(airCarrier.getDestinationNumber())
                .build();
    }


}
