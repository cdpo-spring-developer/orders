package com.springlessons.orders.task01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductService {

    private final WebClient webClient;

    @Autowired
    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://127.0.0.1:8083")
                .build();
    }

    public Mono<Object> getProducts(List<Integer> productIds) {
        String ids = String.join(",", productIds.stream().map(String::valueOf).toList());
        return webClient.get() // http method
                .uri(" /api/v1/catalog/product/{id}", ids)
                .retrieve()
                .toEntity(Product.class)
                .flatMap(voidResponseEntity -> {
            if (!voidResponseEntity.getStatusCode().is2xxSuccessful()) {
                return Mono.just(new Product());
            }
            return Mono.just(Product.class);
        });
    }
}
