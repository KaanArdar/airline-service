package com.demo.airlineservice.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirCarrierRequest {

    private String name;
    private int destinationNumber;
    private int aircraftNumber;
}
