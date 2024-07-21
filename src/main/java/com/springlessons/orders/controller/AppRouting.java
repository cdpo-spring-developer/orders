package com.springlessons.orders.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AppRouting
{
    @Bean
    public RouterFunction<ServerResponse> routes(OrderHandler orderHandler){
        return RouterFunctions.route()
                .POST("/api/v1/order", orderHandler :: create)
                .GET("/api/v1/order/{product_id}", orderHandler :: ordersByProductId)
                .build();
    }



}
