package com.springlessons.orders.service;

import com.springlessons.orders.dto.TraderDto;
import com.springlessons.orders.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    private final WebClient webClient;

    @Autowired
    public UserService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://127.0.0.1:8081")
                .build();
    }

    public Mono<UserDto> userById(int id) {
        return webClient.get() // http method
                .uri("/api/v1/user/{id}", id)
                .retrieve()
                .bodyToMono(UserDto.class);
    }
}
