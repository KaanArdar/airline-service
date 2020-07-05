package com.demo.airlineservice.controller;

import com.demo.airlineservice.model.dto.request.AirportRequest;
import com.demo.airlineservice.model.dto.response.AirportResponse;
import com.demo.airlineservice.service.AirportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/airport")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportResponse> getById(@PathVariable(value = "id") long id){
        return ResponseEntity.ok(airportService.retrieveAirportInfoById(id));
    }

    @PostMapping
    public ResponseEntity<AirportResponse> createAirCarrier(@RequestBody AirportRequest airportRequest){
        AirportResponse airportResponse = airportService.generateAirport(airportRequest);
        return ResponseEntity.ok(airportResponse);
    }
}
