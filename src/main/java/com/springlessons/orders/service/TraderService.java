package com.springlessons.orders.service;

import com.springlessons.orders.dto.TraderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TraderService {
    private final WebClient webClient;

    @Autowired
    public TraderService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://127.0.0.1:8081")
                .build();
    }

    public Mono<TraderDto> traderById(int id) {
        return webClient.get() // http method
                .uri("/api/v1/traders/{id}", id)
                .retrieve()
                .bodyToMono(TraderDto.class);
    }
}
