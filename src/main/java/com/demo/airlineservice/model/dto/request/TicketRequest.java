package com.demo.airlineservice.model.dto.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketRequest {

    private long flightId;
    private String name;
    private String surname;
    private String citizenshipNumber;

}
