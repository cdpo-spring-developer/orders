package com.springlessons.orders.task01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TraderService {
    private final WebClient webClient;

    @Autowired
    public TraderService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://127.0.0.1:8085")
                .build();
    }

    public Mono<Trader> getTraders(List<Integer> traderIds) {
        String ids = String.join(",", traderIds.stream().map(String::valueOf).toList());
        return webClient.get() // http method
                .uri("/api/v1/traders/{id}\n", ids)
                .retrieve()
                .toEntity(Trader.class)
                .flatMap(voidResponseEntity -> {
                    if (!voidResponseEntity.getStatusCode().is2xxSuccessful()) {
                        return Mono.just(new Trader());
                    }
                    return Mono.just(voidResponseEntity.getBody());
                });
    }
}
