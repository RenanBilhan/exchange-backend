package com.renanb.fly_way_backend.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.NumberFormat;
import reactor.core.publisher.Mono;

import java.util.List;

@Table(name = "trip")
public record Trip (

        @Id
        Long idTrip,
        @NotBlank(message = "The trip must have a name")
        String nameTrip,
        @NotBlank(message = "The trip must have a description")
        String description,
        @Positive(message = "The trip must have a price")
//        @Pattern(regexp = "^-?\\d+(\\.\\d+)?$", message = "The price must be a number")
        Double price,
        byte[] thumbnail,
//        @MappedCollection(idColumn = "trip_id", keyColumn = "id_trip_address")
        Long idTripAddress
){
}
