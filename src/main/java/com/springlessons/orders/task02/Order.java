package com.springlessons.orders.task02;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Order {
    private Map<Integer, Integer> products;
    private long price;
}
