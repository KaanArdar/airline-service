package com.demo.airlineservice.service;

import com.demo.airlineservice.model.dto.request.AirportRequest;
import com.demo.airlineservice.model.dto.response.AirportResponse;

public interface AirportService {

    AirportResponse retrieveAirportInfoById(long id);

    AirportResponse generateAirport(AirportRequest airportRequest);

}
