package com.renanb.fly_way_backend.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.validation.constraints.Pattern;


@Table(name = "trip_address")
public record TripAddress (
        @Id
        Long idTripAddress,
        @NotBlank(message = "Country must be informed.")
        String country,

        @NotBlank(message = "Street or avenue must be informed.")
        String streetOrAvenue,
//        @Pattern(regexp = "\\d{5}\\d{3}", message = "Zip code must be in the format XXXXXXXX")
        @NotBlank(message = "Zip code must be informed.")
        String zipCode
){

}
