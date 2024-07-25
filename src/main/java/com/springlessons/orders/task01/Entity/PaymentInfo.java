package com.springlessons.orders.task01.Entity;

public record PaymentInfo(
        Trader trader,
        Product product,
        User user
) {
}
