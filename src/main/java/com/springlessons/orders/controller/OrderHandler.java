package com.springlessons.orders.controller;

import com.springlessons.orders.dto.NewOrderDto;
import com.springlessons.orders.model.Order;
import com.springlessons.orders.repository.OrderRepository;
import com.springlessons.orders.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class OrderHandler {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        var dto = serverRequest.bodyToMono(NewOrderDto.class).block();
        assert dto != null;
        orderService.create(dto);
        return ServerResponse.ok().build();
    }

    public Mono<ServerResponse> ordersByProductId(ServerRequest serverRequest) {
        var productId = Integer.parseInt(serverRequest.pathVariable("product_id"));
        return ServerResponse.ok().body(orderRepository.findAllByProductId(productId), Order.class);
    }
}
