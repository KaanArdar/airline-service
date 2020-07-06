package com.demo.airlineservice.service;

import com.demo.airlineservice.exception.NotFoundEntityException;
import com.demo.airlineservice.exception.UnprocessableEntityException;
import com.demo.airlineservice.model.dto.request.RouteRequest;
import com.demo.airlineservice.model.dto.response.RouteResponse;
import com.demo.airlineservice.model.entity.Route;
import com.demo.airlineservice.repository.RouteRepository;
import com.demo.airlineservice.service.impl.RouteServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RouteServiceTest {

    public RouteService routeService;

    @Mock
    public RouteRepository routeRepository;

    @Before
    public void setUp() throws Exception {
        routeService = new RouteServiceImpl(routeRepository);
    }

    @Test
    public void generateRoute_success(){
        RouteRequest request = RouteRequest.builder()
                .routeCode("test_routeCode")
                .departure("test_departure")
                .destination("test_destination")
                .distance("test_distance")
                .build();

        Route route = Route.builder()
                .id(1)
                .routeCode("test_routeCode")
                .departure("test_departure")
                .destination("test_destination")
                .distance("test_distance")
                .build();


        when(routeRepository.findByRouteCode(Mockito.any())).thenReturn(Optional.empty());
        when(routeRepository.save(Mockito.any())).thenReturn(route);

        RouteResponse routeResponse = routeService.generateRoute(request);

        assertEquals(1,routeResponse.getId());

    }


    @Test(expected = UnprocessableEntityException.class)
    public void generateRoute_Unproccessable(){
        RouteRequest request = RouteRequest.builder()
                .routeCode("test_routeCode")
                .departure("test_departure")
                .destination("test_destination")
                .distance("test_distance")
                .build();

        Route route = Route.builder()
                .id(1)
                .routeCode("test_routeCode")
                .departure("test_departure")
                .destination("test_destination")
                .distance("test_distance")
                .build();


        when(routeRepository.findByRouteCode(Mockito.any())).thenReturn(Optional.of(route));

        RouteResponse routeResponse = routeService.generateRoute(request);

    }


    @Test
    public void retrieveRouteInfoByRouteCode_success() {
        Route route = Route.builder()
                .id(1)
                .routeCode("test_routeCode")
                .departure("test_departure")
                .destination("test_destination")
                .distance("test_distance")
                .build();

        when(routeRepository.findByRouteCode(Mockito.any())).thenReturn(Optional.of(route));

        RouteResponse testRouteResponse = routeService.retrieveRouteInfoByRouteCode("test_routeCode");

        assertEquals(1, testRouteResponse.getId());

    }

    @Test(expected = NotFoundEntityException.class)
    public void retrieveRouteInfoByRouteCode_notFound() {

        when(routeRepository.findByRouteCode(Mockito.any())).thenReturn(Optional.empty());

        RouteResponse testRouteResponse = routeService.retrieveRouteInfoByRouteCode("test_routeCode");

    }

}
