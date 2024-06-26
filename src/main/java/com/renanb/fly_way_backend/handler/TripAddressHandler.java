package com.renanb.fly_way_backend.handler;

import com.renanb.fly_way_backend.repository.TripAddressRepository;
import com.renanb.fly_way_backend.model.TripAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TripAddressHandler {

    private final TripAddressRepository tripAddressRepository;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        Flux<TripAddress> addresses = tripAddressRepository.findAll();
        return ServerResponse.ok().body(addresses, TripAddress.class);
    }
    public Mono<ServerResponse> findById(ServerRequest request){
        Long id = Long.valueOf(request.pathVariable("id"));
        Mono<TripAddress> response = tripAddressRepository.findById(id);
        return ServerResponse.ok().body(response, TripAddress.class);
    }
    public Mono<ServerResponse> save(ServerRequest request){
        Mono<TripAddress> newAddress = request.bodyToMono(TripAddress.class);
        Mono<TripAddress> response = newAddress.flatMap(address -> tripAddressRepository.save(address));
        return ServerResponse.ok().body(response, TripAddress.class);
    }
}