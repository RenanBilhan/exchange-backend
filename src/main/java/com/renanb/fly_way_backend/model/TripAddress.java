package com.renanb.fly_way_backend.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.NumberFormat;


@Table(name = "trip_address")
public record TripAddress (
        @Id
        Long idTripAddress,
        @NotBlank(message = "{country.not.blank}")
        String country,

        @NotBlank(message = "{streetOrAvenue.not.blank}")
        String streetOrAvenue,
//        @Pattern(regexp = "\\d{5}\\d{3}", message = "Zip code must be in the format XXXXXXXX")
        @NotBlank(message = "{zipCode.not.blank}")
        @Pattern(regexp = "\\d{5}\\d{3}", message = "{zipCode.not.blank}")
        String zipCode
){

}
