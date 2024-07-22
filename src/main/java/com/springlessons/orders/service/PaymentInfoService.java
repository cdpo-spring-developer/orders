package com.springlessons.orders.service;

import com.springlessons.orders.model.Product;
import com.springlessons.orders.model.Trader;
import com.springlessons.orders.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static reactor.core.publisher.Mono.just;

@Service
public class PaymentInfoService {

    ProductService productService;
    TraderService traderService;
    UsersService usersService;
    List<Integer> ids = new ArrayList<>();



    public Mono<User> usersMono() {
        return  just(usersService.getUsersByIds(ids).block());
    }


    public Mono<Product> productsMono( ){
        return  just(productService.getProductsByIds(ids).block());
    }

    public Mono<Trader> traderMono( ){
        return just(traderService.getTradersByIds(ids).block());
    }




    public void concatMethods(){

        Mono<User> usersMono = usersMono();
        Mono<Product> productsMono = productsMono();
        Mono<Trader> tradersMono = traderMono();

       Mono<PaimentInfoDto> paimentInfoDtoMono = Mono.zip(usersMono,productsMono,tradersMono)
                .flatMap(objects -> {
                    User user = objects.getT1(); // cat
                    Product product = objects.getT2();
                    Trader trader = objects.getT3();// owner
                    return Mono.empty();
                });

    }



}
