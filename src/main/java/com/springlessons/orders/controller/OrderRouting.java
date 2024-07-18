package com.springlessons.orders.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

public class OrderRouting {
    @Bean
    public RouterFunction<ServerResponse> routes(OrderHandler orderHandler) {
        return RouterFunctions.route()
                .GET("/api/v1/order/{user_id}",
                        request -> orderHandler.getByUserId(request))
                .GET()
                .build();
    }
}
