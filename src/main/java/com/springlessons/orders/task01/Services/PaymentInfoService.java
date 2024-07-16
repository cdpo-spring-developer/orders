package com.springlessons.orders.task01.Services;

import com.springlessons.orders.task01.Entity.PaymentInfo;
import com.springlessons.orders.task01.Entity.Product;
import com.springlessons.orders.task01.Entity.Trader;
import com.springlessons.orders.task01.Entity.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PaymentInfoService {

    private final UserService userService;
    private final TraderService traderService;
    private final ProductService productService;

    public PaymentInfoService(UserService userService, TraderService traderService, ProductService productService) {
        this.userService = userService;
        this.traderService = traderService;
        this.productService = productService;
    }

    public Mono<PaymentInfo> getPaymentInfo(String traderId, String productId, String userId) {
        Mono<Trader> traderMono = traderService.getTraderById(traderId);
        Mono<Product> productMono = productService.getProductById(productId);
        Mono<User> userMono = userService.getUserById(userId);

        return Mono.zip(traderMono, productMono, userMono)
                .map(result -> new PaymentInfo(result.getT1(), result.getT2(), result.getT3()));
    }
}




