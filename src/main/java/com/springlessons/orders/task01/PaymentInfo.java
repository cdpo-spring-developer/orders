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
        Mono.zip(trader.traderMono(), user.userMono(), product.productMono()) // Tuple
                .flatMap(objects -> {
                    Trader trader = objects.getT1();// cat
                    User user = objects.getT2();
                    Product product = objects.getT3();
                    PaymentInfo paymentInfo = new PaymentInfo();
                    paymentInfo.setProduct(product);
                    paymentInfo.setUser(user);
                    paymentInfo.setTrader(trader);
                    // owner
                    return Mono.empty();
                });
    }
}
