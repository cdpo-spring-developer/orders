package com.springlessons.orders.task02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.Set;

@Service
public class ProductService {
    private final WebClient webClient;

    @Autowired
    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://127.0.0.1:8081")
                .build();
    }

    public Mono<Set<Product>> getProducts(Set<Integer> productIds) {
        String ids = String.join(",", productIds.stream().map(String::valueOf).toList());
        return webClient.get() // http method
                .uri("/api/v1/catalog/{ids}", ids)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });

    }
}
