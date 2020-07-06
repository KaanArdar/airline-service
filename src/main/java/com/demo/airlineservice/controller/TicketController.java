package com.demo.airlineservice.controller;

import com.demo.airlineservice.model.dto.request.TicketRequest;
import com.demo.airlineservice.model.dto.response.TicketResponse;
import com.demo.airlineservice.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity purchaseTicket(@RequestBody TicketRequest request){
        ticketService.buyTicket(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponse> findTicket(@PathVariable(value = "id") long id){
        return ResponseEntity.ok(ticketService.retrieveTicketById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeTicket(@PathVariable(value = "id") long id){
        ticketService.removeTicketById(id);
        return ResponseEntity.noContent().build();
    }

}
