package com.springlessons.orders.task03;

import com.springlessons.orders.model.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class OrderHandler {
    private OrderService service;

    public OrderHandler(OrderService service) {
        this.service = service;
    }

    public Mono<ServerResponse> addOrder(ServerRequest request) {
        String orderData = request.pathVariable();
        return  ServerResponse.ok()
                .body(service.archiveOrders(orderData), Order.class);
    }

    public Mono<ServerResponse> getByProductId(ServerRequest request) {
        Integer productId = Integer.parseInt(request.pathVariable("product_id"));
        return ServerResponse.ok()
                .body(service.getOrders(productId), Order.class);
    }

    public Mono<ServerResponse> getByProductIdAndPrice(ServerRequest request) {

        return ServerResponse.ok()
                .body(service.getOrdersAndPrice(), Order.class);
    }
}
