package com.demo.airlineservice.repository;

import com.demo.airlineservice.model.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {

}
