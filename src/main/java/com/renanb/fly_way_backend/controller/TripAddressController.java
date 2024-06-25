package com.renanb.fly_way_backend.controller;

import com.renanb.fly_way_backend.service.TripAddressService;
import com.renanb.fly_way_backend.model.TripAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("addresses")
public class TripAddressController {

    private final TripAddressService addressService;

    @PostMapping
    public ResponseEntity<Mono<TripAddress>> save (@Validated @RequestBody TripAddress tripAddress){
        return ResponseEntity.ok(addressService.save(tripAddress));
    }
    @GetMapping()
    public ResponseEntity<Flux<TripAddress>> findAll(){
        return ResponseEntity.ok(addressService.findAll());
    }

}
