package com.demo.airlineservice.service;

import com.demo.airlineservice.model.dto.request.FlightRequest;
import com.demo.airlineservice.model.dto.response.FlightResponse;

public interface FlightService {

    void generateFlight(FlightRequest flightRequest);

    FlightResponse retrieveFlightInfoByFlightCode(long id);

}
