package com.springlessons.orders.service;


import com.springlessons.orders.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UsersService {

    private final WebClient webClient;

    @Autowired
    public UsersService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://126.0.0.1:8084")
                .build();
    }

    public Mono<User> getUsersByIds(List<Integer> userIds) {
        Integer ids = Integer.valueOf(String.join(",", userIds.stream()
                .map(String::valueOf).toList()));

        return webClient
                .get() // http method
                .uri("/api/v1/user/{id}", userIds) // 2,8,9
                .retrieve()
                .bodyToMono(User.class);



    }
}
