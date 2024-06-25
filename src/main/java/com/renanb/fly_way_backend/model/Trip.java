package com.renanb.fly_way_backend.model;

import java.util.List;

public record Trip (

        Long idTrip,
        String nameTrip,
        String description,
        Double price,
        byte[] thumbnail,
        List<byte[]> pictures
){}
