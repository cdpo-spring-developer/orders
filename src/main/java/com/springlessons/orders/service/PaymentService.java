package com.springlessons.orders.service;

import com.springlessons.orders.dto.PaymentInfoDto;
import com.springlessons.orders.dto.TraderDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PaymentService {

    private final ProductService productService;
    private final TraderService traderService;
    private final UserService userService;

    Mono<PaymentInfoDto> getPaymentInfo(int productId, int traderId, int userId) {
        var p = productService.productById(productId);
        Mono<TraderDto> t = traderService.traderById(traderId);
        var u = userService.userById(userId);

        return Mono.zip(t, u, p)
                .map(x -> new PaymentInfoDto(x.getT1(), x.getT2(), x.getT3()));
    }

}
