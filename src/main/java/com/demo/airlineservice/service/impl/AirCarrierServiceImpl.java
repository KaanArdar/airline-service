package com.demo.airlineservice.service.impl;

import com.demo.airlineservice.exception.NotFoundEntityException;
import com.demo.airlineservice.mapper.AirCarrierMapper;
import com.demo.airlineservice.model.dto.request.AirCarrierRequest;
import com.demo.airlineservice.model.dto.response.AirCarrierResponse;
import com.demo.airlineservice.model.entity.AirCarrier;
import com.demo.airlineservice.repository.AirCarrierRepository;
import com.demo.airlineservice.service.AirCarrierService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirCarrierServiceImpl implements AirCarrierService {

    private final AirCarrierRepository airCarrierRepository;

    private final String NOT_FOUND = "Entity not found!";

    public AirCarrierServiceImpl(AirCarrierRepository airCarrierRepository) {
        this.airCarrierRepository = airCarrierRepository;
    }

    @Override
    public AirCarrierResponse generateAirCarrier(AirCarrierRequest airCarrierRequest) {
        AirCarrier airCarrier = airCarrierRepository.save(AirCarrierMapper.requestToEntity(airCarrierRequest));
        return AirCarrierMapper.entityToResponse(airCarrier);
    }

    @Override
    public List<AirCarrierResponse> retrieveAllAirCarrierInfo() {
        return airCarrierRepository.findAll()
                .stream()
                .map(AirCarrierMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AirCarrierResponse retrieveAirCarrierInfoById(long id) {
        return airCarrierRepository.findById(id)
                .map(AirCarrierMapper::entityToResponse)
                .orElseThrow(() -> new NotFoundEntityException(NOT_FOUND));
    }
}
