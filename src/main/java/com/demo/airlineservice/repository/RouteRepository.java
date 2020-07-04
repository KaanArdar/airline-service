package com.demo.airlineservice.repository;


import com.demo.airlineservice.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {

}
