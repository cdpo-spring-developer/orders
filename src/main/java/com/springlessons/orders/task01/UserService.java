package com.springlessons.orders.task01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserService {
    private final WebClient webClient;

    @Autowired
    public UserService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://127.0.0.1:8084")
                .build();
    }

    public Mono<ResponseEntity<User>> getUsers(List<Integer> userIds) {
        String ids = String.join(",", userIds.stream().map(String::valueOf).toList());
        return webClient.get() // http method
                .uri("/api/v1/user/{id}", ids)
                .retrieve()
                .toEntity(User.class);
    }
}
