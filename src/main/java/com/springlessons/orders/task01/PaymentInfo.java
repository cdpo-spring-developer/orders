package com.springlessons.orders.task01;

import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
public class PaymentInfo {
    private Trader trader;
    private User user;
    private Product product;

    public void concat() {
       /* Mono<Trader> traderMono = trader.traderMono();
        Mono<User> userMono = user.userMono();
        Mono<Product> productMono = product.productMono();*/

    }
}
