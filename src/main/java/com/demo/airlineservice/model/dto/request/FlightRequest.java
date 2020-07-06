package com.demo.airlineservice.model.dto.request;


import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;

@Data
@Builder
public class FlightRequest {

    private String flightCode;
    private String routeCode;
    private BigDecimal price;
    private int availableSeat;
    private int totalSeat;

}
