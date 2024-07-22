package com.springlessons.orders.service;

import com.springlessons.orders.model.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
                .baseUrl("http://128.0.0.1:8082")
                .build();
    }



    public Mono<Trader> getTradersByIds(List<Integer> traderIds){
        Integer ids = Integer.valueOf(String.join(",", traderIds.stream()
                .map(String::valueOf).toList()));
        return webClient.get() // http method
                .uri("/api/v1/traders/{id}", ids) // 2,8,9
                .retrieve()
                .bodyToMono(Trader.class);


    }

    }

