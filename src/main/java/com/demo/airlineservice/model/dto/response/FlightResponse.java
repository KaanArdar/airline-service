package com.demo.airlineservice.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class FlightResponse {

    private String flightCode;
    private RouteResponse routeInfo;
    private BigDecimal price;
    private int availableSeat;

}
