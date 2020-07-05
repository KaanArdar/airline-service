
package com.demo.airlineservice.service;


import com.demo.airlineservice.exception.NotFoundEntityException;
import com.demo.airlineservice.model.dto.request.AirCarrierRequest;
import com.demo.airlineservice.model.dto.response.AirCarrierResponse;
import com.demo.airlineservice.model.entity.AirCarrier;
import com.demo.airlineservice.repository.AirCarrierRepository;
import com.demo.airlineservice.service.impl.AirCarrierServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class AirCarrierServiceTest {

    private AirCarrierService airCarrierService;

    @Mock
    private AirCarrierRepository airCarrierRepository;

    @Before
    public void setUp() throws Exception {
        airCarrierService = new AirCarrierServiceImpl(airCarrierRepository);
    }

    @Test
    public void generateAirCarrier_test() {
        AirCarrierRequest airCarrierRequest = AirCarrierRequest.builder().destinationNumber(1).name("test").aircraftNumber(1).build();
        AirCarrier airCarrier = AirCarrier.builder().id(5).destinationNumber(1).name("test").aircraftNumber(1).build();

        when(airCarrierRepository.save(Mockito.any())).thenReturn(airCarrier);

        AirCarrierResponse carrier = airCarrierService.generateAirCarrier(airCarrierRequest);

        assertEquals(5,carrier.getId());

    }

    @Test
    public void retrieveAllAirCarrierInfo_test() {
        AirCarrier airCarrier1 = AirCarrier.builder().id(5).destinationNumber(1).name("test").aircraftNumber(1).build();
        AirCarrier airCarrier2 = AirCarrier.builder().id(6).destinationNumber(1).name("test").aircraftNumber(1).build();

        when(airCarrierRepository.findAll()).thenReturn(Arrays.asList(airCarrier1,airCarrier2));

        List<AirCarrierResponse> airCarrierResponses = airCarrierService.retrieveAllAirCarrierInfo();

        assertEquals(2,airCarrierResponses.size());

    }

    @Test
    public void retrieveAirCarrierInfoById_test_success() {

        AirCarrier airCarrier = AirCarrier.builder().id(5).destinationNumber(1).name("test").aircraftNumber(1).build();

        when(airCarrierRepository.findById(Mockito.any())).thenReturn(Optional.of(airCarrier));

        AirCarrierResponse airCarrierResponse = airCarrierService.retrieveAirCarrierInfoById(5);

        assertEquals(5,airCarrierResponse.getId());
    }

    @Test(expected = NotFoundEntityException.class)
    public void retrieveAirCarrierInfoById_test_notFound() {

        AirCarrier airCarrier = AirCarrier.builder().id(5).destinationNumber(1).name("test").aircraftNumber(1).build();

        when(airCarrierRepository.findById(Mockito.any())).thenThrow(NotFoundEntityException.class);

        AirCarrierResponse airCarrierResponse = airCarrierService.retrieveAirCarrierInfoById(5);

    }

}
