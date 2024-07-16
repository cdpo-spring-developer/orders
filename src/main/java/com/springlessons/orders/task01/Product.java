package com.springlessons.orders.task01;


import lombok.Data;
import reactor.core.publisher.Mono;

@Data
public class Product {
    private String name;

    public Mono<Product> productMono() {
        return Mono.just(
                new Product()
        );
    }

}
