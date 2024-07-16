package com.springlessons.orders.task01.Services;

import com.springlessons.orders.task01.Entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final WebClient webClient;

    public ProductService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Mono<Product> getProductById(String productId) {
        return webClient.get()
                .uri("/api/v1/catalog/product/{id}", productId)
                .retrieve()
                .bodyToMono(Product.class);
    }
}
