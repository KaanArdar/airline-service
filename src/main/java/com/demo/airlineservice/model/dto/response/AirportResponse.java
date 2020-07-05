package com.demo.airlineservice.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AirportResponse {

    private long id;
    private String name;
    private String city;
    private String address;
}
