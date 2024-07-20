package com.springlessons.orders.task03;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
public class OrderHandler {
    private final OrderService service;

    public OrderHandler(OrderService service) {
        this.service = service;
    }

    public Mono<ServerResponse> addOrder(ServerRequest request) {
        Order order = new Order();
        Flux<ProductDAO> products = request.bodyToFlux(ProductDAO.class);
        String orderName = request.queryParam("order_name").orElseThrow();
        return ServerResponse.ok()
                .body(service.save(order, products.toStream().toList(), orderName), Order.class);
    }

    public Mono<ServerResponse> getByProductId(ServerRequest request) {
        int productId = Integer.parseInt(request.pathVariable("product_id"));
        return ServerResponse.ok()
                .body(service.findByUserId(productId), Order.class);
    }

    public Mono<ServerResponse> getByProductIdAndPrice(ServerRequest request) {
        int userId = Integer.parseInt(request.pathVariable("user_id"));
        double price = Double.parseDouble(request.queryParam("price").orElseThrow());
        return ServerResponse.ok()
                .body(service.findByUserIdAndPrice(userId, price), Order.class);
    }
}
