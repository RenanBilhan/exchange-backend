package com.renanb.fly_way_backend.model;

import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

public record Trip (

        Long idTrip,
        String nameTrip,
        String description,
        Double price,
        byte[] thumbnail,
        @MappedCollection(idColumn = "trip_id", keyColumn = "id_trip_address")
        TripAddress tripAddress
){}
