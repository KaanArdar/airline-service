package com.demo.airlineservice.repository;

import com.demo.airlineservice.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Modifying
    @Query(value = "UPDATE FLIGHTS f SET " +
            "available_seat = :available_seat , " +
            "f.price =:price WHERE f.id =:id ", nativeQuery = true)
    void updateAvailableSeat(@Param("id") long id, @Param("available_seat") int availableSeat, @Param("price") BigDecimal price);

}
