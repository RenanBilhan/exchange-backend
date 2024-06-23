package com.renanb.fly_way_backend.service;

import com.renanb.fly_way_backend.repository.TripAddressRepository;
import com.renanb.fly_way_backend.model.TripAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TripAddressService {

    private final TripAddressRepository tripAddressRepository;

    public Mono<TripAddress> save(TripAddress tripAddress){
        return tripAddressRepository.save(tripAddress);
    }
    public Flux<TripAddress> findAll(){
        return tripAddressRepository.findAll();
    }
}
