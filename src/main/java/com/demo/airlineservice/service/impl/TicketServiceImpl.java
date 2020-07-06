package com.demo.airlineservice.service.impl;

import com.demo.airlineservice.exception.NotFoundEntityException;
import com.demo.airlineservice.exception.UnprocessableEntityException;
import com.demo.airlineservice.mapper.TicketMapper;
import com.demo.airlineservice.model.dto.request.TicketRequest;
import com.demo.airlineservice.model.dto.response.FlightResponse;
import com.demo.airlineservice.model.dto.response.TicketResponse;
import com.demo.airlineservice.repository.TicketRepository;
import com.demo.airlineservice.service.FlightService;
import com.demo.airlineservice.service.TicketService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private static final String TICKET_SOLD_OUT= "there is no ticket to be sold.";
    private static final String NOT_FOUND= "Ticket not found!";
    private final String UN_PROCESSABLE = "Unprocessable entity!";

    private final TicketRepository ticketRepository;
    private final FlightService flightService;


    public TicketServiceImpl(TicketRepository ticketRepository, FlightService flightService) {
        this.ticketRepository = ticketRepository;
        this.flightService = flightService;
    }

    @Override
    @Transactional
    public void buyTicket(TicketRequest request) {
        Optional.of(flightService.retrieveFlightInfoByFlightId(request.getFlightId()))
        .filter(flightResponse -> flightResponse.getAvailableSeat() > 0)
        .map(flightResponse -> {
            ticketRepository.save(TicketMapper.requestToEntity(request, flightResponse.getPrice()));
            flightService.updateAvailableSeat(request.getFlightId());
            return true;
        })
        .orElseThrow(() -> new UnprocessableEntityException(TICKET_SOLD_OUT));
    }

    @Override
    public TicketResponse retrieveTicketById(long id) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    FlightResponse flightResponse = flightService.retrieveFlightInfoByFlightId(ticket.getFlightId());
                    return TicketMapper.entityToResponse(ticket,flightResponse);
                }).orElseThrow( () -> new NotFoundEntityException(NOT_FOUND));
    }

    @Override
    public void removeTicketById(long id) {
        ticketRepository.findById(id)
                .map(ticket -> {
                    ticketRepository.deleteById(id);
                    return true;
                })
                .orElseThrow(() -> new UnprocessableEntityException(UN_PROCESSABLE));
    }

}
