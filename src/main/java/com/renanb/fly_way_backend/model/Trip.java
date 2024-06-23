package com.renanb.fly_way_backend.model;

public record Trip (

        Long idTrip,
        String nameTrip,
        String description,
        Double price,
        byte[] thumbnail
){}
