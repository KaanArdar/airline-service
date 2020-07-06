package com.demo.airlineservice.service;

import com.demo.airlineservice.repository.FlightRepository;
import com.demo.airlineservice.repository.RouteRepository;
import com.demo.airlineservice.service.impl.FlightServiceImpl;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class FlightServiceTest {

    public FlightService flightService;

    @Mock
    public FlightRepository flightRepository;

    @Mock
    public RouteRepository routeRepository;

    @Before
    public void setUp() throws Exception {
        flightService = new FlightServiceImpl(routeRepository, flightRepository);
    }
}
