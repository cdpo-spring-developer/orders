package com.springlessons.orders.task03;

import lombok.Data;

@Data
public class ProductDAO {
    @Positive
    private int id;
    @NotNull
    private String name;
    @Positive
    private double price;
    @Positive
    private int amount;
}
