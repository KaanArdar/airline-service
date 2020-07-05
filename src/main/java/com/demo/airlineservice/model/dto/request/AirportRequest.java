package com.demo.airlineservice.model.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AirportRequest {

    private String name;
    private String city;
    private String address;
}
