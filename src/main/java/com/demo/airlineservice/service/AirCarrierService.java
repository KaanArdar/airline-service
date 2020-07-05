package com.demo.airlineservice.service;

import com.demo.airlineservice.model.dto.request.AirCarrierRequest;
import com.demo.airlineservice.model.dto.response.AirCarrierResponse;

import java.util.List;

public interface AirCarrierService {

    AirCarrierResponse generateAirCarrier(AirCarrierRequest airCarrierRequest);

    List<AirCarrierResponse> retrieveAllAirCarrierInfo();

    AirCarrierResponse retrieveAirCarrierInfoById(long id);

}
