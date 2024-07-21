package com.springlessons.orders.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private String name;
    private int id;
    private int price;
    private int count;

}
