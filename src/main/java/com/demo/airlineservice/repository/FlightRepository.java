package com.demo.airlineservice.repository;

import com.demo.airlineservice.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {



}