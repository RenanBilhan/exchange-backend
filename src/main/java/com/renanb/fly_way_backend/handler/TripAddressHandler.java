package com.renanb.fly_way_backend.handler;

import com.renanb.fly_way_backend.repository.TripAddressRepository;
import com.renanb.fly_way_backend.model.TripAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Validated
public class TripAddressHandler {

    private final Validator validator;

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
        Mono<TripAddress> newAddress = request.bodyToMono(TripAddress.class).doOnNext(this::validate);
        Mono<TripAddress> response = newAddress.flatMap(address -> tripAddressRepository.save(address));
        return ServerResponse.ok().body(response, TripAddress.class);
    }

    private void validate(TripAddress address) {
        Errors errors = new BeanPropertyBindingResult(address, "address");
        validator.validate(address, errors);
        if (errors.hasErrors()) {
            throw new ServerWebInputException(errors.toString());
        }
    }
}