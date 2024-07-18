package com.springlessons.orders.task03;


import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

public class OrderRouting {
    @Bean
    public RouterFunction<ServerResponse> routes(OrderHandler orderHandler) {
        return RouterFunctions.route()
                .POST("/order",
                        orderHandler::addOrder)
                .GET("order/{productID}",
                        orderHandler::getByProductId)
                .GET("order/{userId}/filter",
                        orderHandler::getByProductIdAndPrice)
                .build();
    }
}
