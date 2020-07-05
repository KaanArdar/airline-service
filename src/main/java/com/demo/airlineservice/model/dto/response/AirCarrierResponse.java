package com.demo.airlineservice.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AirCarrierResponse {

    private long id;
    private String name;
    private int destinationNumber;
    private int aircraftNumber;

}
