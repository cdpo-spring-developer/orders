package com.springlessons.orders.task01.Services;

import com.springlessons.orders.task01.Entity.Trader;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TraderService {

    private final WebClient webClient;

    public TraderService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Mono<Trader> getTraderById(String traderId) {
        return webClient.get()
                .uri("/api/v1/traders/{id}", traderId)
                .retrieve()
                .bodyToMono(Trader.class);
    }
}
