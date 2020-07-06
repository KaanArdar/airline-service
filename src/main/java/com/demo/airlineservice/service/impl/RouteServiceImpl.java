package com.demo.airlineservice.service.impl;

import com.demo.airlineservice.exception.NotFoundEntityException;
import com.demo.airlineservice.exception.UnprocessableEntityException;
import com.demo.airlineservice.mapper.RouteMapper;
import com.demo.airlineservice.model.dto.request.RouteRequest;
import com.demo.airlineservice.model.dto.response.RouteResponse;
import com.demo.airlineservice.model.entity.Route;
import com.demo.airlineservice.repository.RouteRepository;
import com.demo.airlineservice.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    private final String NOT_FOUND = "Entity not found!";
    private final String UN_PROCESSABLE = "Unprocessable entity!";

    private final RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public RouteResponse generateRoute(RouteRequest routeRequest) {
        Optional<Route> byRouteCode = routeRepository.findByRouteCode(routeRequest.getRouteCode());

        if (byRouteCode.isPresent()){
            throw new UnprocessableEntityException(UN_PROCESSABLE);
        }

        Route route = routeRepository.save(RouteMapper.requestToEntity(routeRequest));

        return RouteMapper.entityToResponse(route);
    }

    @Override
    public RouteResponse retrieveRouteInfoByRouteCode(String routeCode) {
        return routeRepository.findByRouteCode(routeCode)
                .map(RouteMapper::entityToResponse)
                .orElseThrow(() -> new NotFoundEntityException(NOT_FOUND));
    }
}
