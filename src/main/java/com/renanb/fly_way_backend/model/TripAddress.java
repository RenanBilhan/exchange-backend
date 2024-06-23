package com.renanb.fly_way_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "trip_address")
public record TripAddress (
        @Id
        Long idTripAddress,
        String country,
        String streetOrAvenue,
        String zipCode
){

}
