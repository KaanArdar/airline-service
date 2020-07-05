package com.demo.airlineservice.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "air_carrier")
@NoArgsConstructor
@AllArgsConstructor
public class AirCarrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "destination_number")
    private int destinationNumber;

    @Column(name = "aircraft_number")
    private int aircraftNumber;

}
