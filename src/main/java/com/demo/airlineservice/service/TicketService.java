package com.demo.airlineservice.service;

import com.demo.airlineservice.model.dto.request.TicketRequest;
import com.demo.airlineservice.model.dto.response.TicketResponse;

public interface TicketService {

    void buyTicket(TicketRequest request);

    TicketResponse retrieveTicketById(long id);

    void removeTicketById(long id);

}
