package com.demo.airlineservice.service;


import com.demo.airlineservice.exception.NotFoundEntityException;
import com.demo.airlineservice.model.dto.request.AirportRequest;
import com.demo.airlineservice.model.dto.response.AirportResponse;
import com.demo.airlineservice.model.entity.Airport;
import com.demo.airlineservice.repository.AirportRepository;
import com.demo.airlineservice.service.impl.AirportServiceImpl;
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
public class AirPortServiceTest {

    private AirportService airportService;

    @Mock
    private AirportRepository airportRepository;

    @Before
    public void setUp() throws Exception {
        airportService = new AirportServiceImpl(airportRepository);
    }

    @Test
    public void generateAirport_test() {
        AirportRequest airportRequest = AirportRequest.builder().name("testName").city("testCity").address("testAddress").build();
        Airport airport = Airport.builder().id(1).name("testName").city("testCity").address("testAddress").build();

        when(airportRepository.save(Mockito.any())).thenReturn(airport);

        AirportResponse airportResponse = airportService.generateAirport(airportRequest);

        assertEquals(1, airportResponse.getId());

    }

    @Test
    public void retrieveAirportInfoById_test_success() {
        Airport airport = Airport.builder().id(1).name("testName").city("testCity").address("testAddress").build();

        when(airportRepository.findById(Mockito.any())).thenReturn(Optional.of(airport));

        AirportResponse airportResponse = airportService.retrieveAirportInfoById(1);

        assertEquals(1, airportResponse.getId());

    }

    @Test(expected = NotFoundEntityException.class)
    public void retrieveAirportInfoById_test_notFound() {
        Airport airport = Airport.builder().id(1).name("testName").city("testCity").address("testAddress").build();

        when(airportRepository.findById(Mockito.any())).thenThrow(NotFoundEntityException.class);

        AirportResponse airportResponse = airportService.retrieveAirportInfoById(1);

    }
}
