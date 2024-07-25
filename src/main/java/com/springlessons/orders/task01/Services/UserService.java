package com.springlessons.orders.task01.Services;

import com.springlessons.orders.task01.Entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final WebClient webClient;

    public UserService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Mono<User> getUserById(String userId) {
        return webClient.get()
                .uri("/api/v1/user/{id}", userId)
                .retrieve()
                .bodyToMono(User.class);
    }
}
