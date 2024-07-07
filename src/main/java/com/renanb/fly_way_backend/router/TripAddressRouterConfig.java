package com.renanb.fly_way_backend.router;

import com.renanb.fly_way_backend.handler.TripAddressHandler;
import com.renanb.fly_way_backend.handler.TripHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class TripAddressRouterConfig {

    private final TripAddressHandler tripAddressHandler;
    private final TripHandler tripHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/addresses", tripAddressHandler::findAll)
                .GET("/addresses/{id}", tripAddressHandler::findById)
                .POST("/addresses", tripAddressHandler::save)
                .GET("/trips", tripHandler::findAll)
                .POST("/trips/{idAddress}", tripHandler::save)
                .build();
    }
}