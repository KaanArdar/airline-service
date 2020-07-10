package com.demo.airlineservice.mapper;

import com.demo.airlineservice.model.dto.request.TicketRequest;
import com.demo.airlineservice.model.dto.response.FlightResponse;
import com.demo.airlineservice.model.dto.response.TicketResponse;
import com.demo.airlineservice.model.entity.Ticket;

import java.math.BigDecimal;
import java.time.Instant;

public class TicketMapper {

    public static Ticket requestToEntity(TicketRequest request,String maskingCard, BigDecimal price){
        return Ticket.builder()
                .citizenshipNumber(request.getCitizenshipNumber())
                .createdDate(Instant.now().getEpochSecond())
                .flightId(request.getFlightId())
                .cardNumber(maskingCard)
                .name(request.getName())
                .surname(request.getSurname())
                .price(price)
                .build();
    }

    public static TicketResponse entityToResponse(Ticket ticket, FlightResponse flightResponse){
        return TicketResponse.builder()
                .citizenshipNumber(ticket.getCitizenshipNumber())
                .createdDate(ticket.getCreatedDate())
                .name(ticket.getName())
                .surname(ticket.getSurname())
                .price(ticket.getPrice())
                .flightInfo(flightResponse)
                .cardNumber(ticket.getCardNumber())
                .build();
    }
}
