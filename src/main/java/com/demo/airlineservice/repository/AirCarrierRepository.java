package com.demo.airlineservice.repository;


import com.demo.airlineservice.model.entity.AirCarrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirCarrierRepository extends JpaRepository<AirCarrier, Long> {

}
