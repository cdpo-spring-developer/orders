package com.springlessons.orders.task01;

import lombok.Data;
import reactor.core.publisher.Mono;

@Data
public class Trader {
    private String name;
    private String inn;
    private String phone;
}
