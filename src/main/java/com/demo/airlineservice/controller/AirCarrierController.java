package com.demo.airlineservice.controller;



import com.demo.airlineservice.model.dto.request.AirCarrierRequest;
import com.demo.airlineservice.model.dto.response.AirCarrierResponse;
import com.demo.airlineservice.model.entity.AirCarrier;
import com.demo.airlineservice.service.AirCarrierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/air-carrier")
public class AirCarrierController {

    private final AirCarrierService airCarrierService;

    public AirCarrierController(AirCarrierService airCarrierService) {
        this.airCarrierService = airCarrierService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirCarrierResponse> getAirCarrierById(@PathVariable(value = "id") long id){
        return ResponseEntity.ok(airCarrierService.retrieveAirCarrierInfoById(id));
    }

    @GetMapping
    public ResponseEntity<List<AirCarrierResponse>> getAllAirCarrier() {
        return ResponseEntity.ok(airCarrierService.retrieveAllAirCarrierInfo());
    }

    @PostMapping
    public ResponseEntity<AirCarrierResponse> createAirCarrier(@RequestBody AirCarrierRequest airCarrierRequest){
        AirCarrierResponse airCarrier = airCarrierService.generateAirCarrier(airCarrierRequest);
        return ResponseEntity.ok(airCarrier);
    }

}
