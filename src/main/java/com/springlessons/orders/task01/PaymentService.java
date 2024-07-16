package com.springlessons.orders.task01;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentService {
    ProductService productService;
    TraderService traderService;
    UserService userService;


    public Mono<PaymentInfo> getPaymentInfo() {
        Mono<User> monoUser = userService.getUsers();
        Mono<Trader> monoTrader = traderService.getTraders();
        Mono<Product> monoProduct = productService.getProducts();
        Mono<PaymentInfo> paymentInfoMono = Mono.zip(monoTrader, monoUser, monoProduct) // Tuple
                .flatMap(objects -> {
                    Trader trader = objects.getT1();// cat
                    User user = objects.getT2();
                    Product product = objects.getT3();
                    PaymentInfo paymentInfo = new PaymentInfo();
                    paymentInfo.setProduct(product);
                    paymentInfo.setUser(user);
                    paymentInfo.setTrader(trader);
                    return Mono.just(paymentInfo);
                });
        return paymentInfoMono;
    }
}
