package com.renanb.fly_way_backend.router;

import com.renanb.fly_way_backend.handler.TripHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class TripRouterConfig {

    private final TripHandler tripHandler;


    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/trips", tripHandler::findAll)
                .POST("/trips/{addressId}", tripHandler::save)
                .build();
    }
}
