package com.demo.airlineservice.model.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RouteRequest {

    private String routeCode;
    private String departure;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private String distance;

}
