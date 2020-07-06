package com.demo.airlineservice.controller;

import com.demo.airlineservice.model.dto.request.RouteRequest;
import com.demo.airlineservice.model.dto.response.RouteResponse;
import com.demo.airlineservice.service.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    public ResponseEntity<RouteResponse> createRoute(@RequestBody RouteRequest routeRequest){
        RouteResponse routeResponse = routeService.generateRoute(routeRequest);
        return ResponseEntity.ok(routeResponse);
    }

    @GetMapping("/route-code")
    public ResponseEntity<RouteResponse> getRouteByRouteCode(@RequestParam(value = "routeCode") String routeCode){
        return ResponseEntity.ok(routeService.retrieveRouteInfoByRouteCode(routeCode));
    }

}


