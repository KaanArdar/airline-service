package com.demo.airlineservice.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RouteResponse {

    private long id;
    private String routeCode;
    private String departure;
    private String destination;
    private String distance;

}
