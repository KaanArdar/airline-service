package com.demo.airlineservice.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class TicketResponse {

    private long id;
    private String name;
    private String surname;
    private String citizenshipNumber;
    private long createdDate;
    private BigDecimal price;
    private FlightResponse flightInfo;
    private String cardNumber;

}
