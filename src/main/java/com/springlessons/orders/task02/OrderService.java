package com.springlessons.orders.task02;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Set;

@Service
public class OrderService {
    ProductService productService;

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public Mono<Order> makeOrder(Map<Integer, Integer> products) {
        Mono<Set<Product>> productMono = productService.getProducts(products.keySet());
        Set<Product> productSet = productMono.block();
        long commonPrice = productSet.stream().mapToLong(Product::getPrice).sum();
        return Mono.just(new Order(products, commonPrice));
    }
}
