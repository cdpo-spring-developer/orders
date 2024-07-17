package com.springlessons.orders.service;


import com.springlessons.orders.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductService {

    private final WebClient webClient;
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public ProductService(@Qualifier("webClientBuilder") WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://127.0.0.1:8081")
                .build();
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<Product> getProductsByIds(List<Integer> productsIds){
        Integer ids = Integer.valueOf(String.join(",", productsIds.stream()
                .map(String::valueOf).toList()));

        return webClient
                .get()// http method
                .uri("/api/v1/catalog/product/{id}", productsIds) // 2,8,9
                .retrieve()
                .bodyToMono(Product.class);


    }
}
