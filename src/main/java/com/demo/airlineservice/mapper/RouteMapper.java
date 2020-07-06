package com.demo.airlineservice.mapper;

import com.demo.airlineservice.model.dto.request.RouteRequest;
import com.demo.airlineservice.model.dto.response.RouteResponse;
import com.demo.airlineservice.model.entity.Route;

public class RouteMapper {

    public static Route requestToEntity(RouteRequest request){
        return Route.builder()
                .routeCode(request.getRouteCode())
                .departure(request.getDeparture())
                .arrivalDate(request.getArrivalDate())
                .departureDate(request.getDepartureDate())
                .destination(request.getDestination())
                .distance(request.getDistance())
                .build();
    }

    public static RouteResponse entityToResponse(Route route){
        return RouteResponse.builder()
                .id(route.getId())
                .routeCode(route.getRouteCode())
                .departure(route.getDeparture())
                .destination(route.getDestination())
                .distance(route.getDistance())
                .build();
    }

}
