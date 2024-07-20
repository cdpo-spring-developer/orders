package com.springlessons.orders.task03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Order> findByUserId(int userId) {
       return orderRepository.findByUserId(userId);
    }

    public Flux<Order> findByUserIdAndPrice(int userId, double price) {

        return orderRepository.findByUserIdAndPrice(userId, price);
    }

    public Mono<Order> save(Order order,  List<ProductDAO> products, String name) {
        order.setId(UUID.randomUUID());
        order.setName(name);
        order.setProducts(products);
        order.setCommonPrice(products.stream()
                .mapToDouble(ProductDAO::getPrice).sum());
        order.setActive(true);
       return orderRepository.save(order);
    }
}
