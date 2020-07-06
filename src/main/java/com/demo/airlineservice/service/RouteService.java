package com.demo.airlineservice.service;

import com.demo.airlineservice.model.dto.request.RouteRequest;
import com.demo.airlineservice.model.dto.response.RouteResponse;

public interface RouteService {

    RouteResponse generateRoute(RouteRequest routeRequest);

    RouteResponse retrieveRouteInfoByRouteCode(String routeCode);

}
