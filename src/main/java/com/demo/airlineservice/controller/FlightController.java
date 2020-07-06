package com.demo.airlineservice.controller;

import com.demo.airlineservice.model.dto.request.FlightRequest;
import com.demo.airlineservice.model.dto.response.FlightResponse;
import com.demo.airlineservice.service.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> getByFlightCode(@PathVariable(value = "id") long id){
        return ResponseEntity.ok(flightService.retrieveFlightInfoByFlightId(id));
    }

    @PostMapping
    public ResponseEntity createFlight(@RequestBody FlightRequest flightRequest){
        flightService.generateFlight(flightRequest);
        return ResponseEntity.ok().build();
    }
}
