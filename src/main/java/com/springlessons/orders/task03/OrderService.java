package com.springlessons.orders.task03;

import com.springlessons.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class OrderService {
    private final WebClient webClient;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(WebClient.Builder webClientBuilder, OrderRepository orderRepository) {
        this.webClient = webClientBuilder
                .baseUrl("http://127.0.0.1:8081")
                .build();
        this.orderRepository = orderRepository;
    }

    public Mono<List<Product>> archiveOrders(String orderData) {
      /*  orderRepository.saveAll(webClient.get() // http method
                .uri("/order", orderData) // 2,8,9
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                }));*/

        return webClient.get() // http method
                .uri("/order", orderData) // 2,8,9
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    public Mono<List<Order>> getOrders(int productId) {
        return  webClient.get() // http method
                .uri("order/{productID}", productId) // 2,8,9
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    public Mono<List<Order>> getOrdersAndPrice(int productId) {
        return  webClient.get() // http method
                .uri("order/{productID}", productId) // 2,8,9
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
    }

    public void save(List<Order> orders) {
        orderRepository.saveAll(orders);
    }
}
