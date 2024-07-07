package com.renanb.fly_way_backend.handler;

import com.renanb.fly_way_backend.exception.exceptions.AddressNotFoundException;
import com.renanb.fly_way_backend.exception.validator.InputValidator;
import com.renanb.fly_way_backend.model.Trip;
import com.renanb.fly_way_backend.repository.TripAddressRepository;
import com.renanb.fly_way_backend.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TripHandler {

    private final TripRepository tripRepository;
    private final InputValidator inputValidator;
    private final TripAddressRepository tripAddressRepository;

    public Mono<ServerResponse> findAll(ServerRequest request){
        Flux<Trip> tripFlux= tripRepository.findAll();
        return ServerResponse.ok().body(tripFlux,Trip.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
        Mono<Trip> tripMono = request.bodyToMono(Trip.class)
                .doOnNext(this::validate);
        Mono<Trip> response = tripMono.flatMap(trip -> {return tripRepository.save(trip);})
                .switchIfEmpty(Mono.error(new AddressNotFoundException("Falha ao salvar endereco.")));
        return ServerResponse.ok().body(response, Trip.class);
    }

    private <T> void validate(T trip){
        inputValidator.validate(trip);
    }
}
