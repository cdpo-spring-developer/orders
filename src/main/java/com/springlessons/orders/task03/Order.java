package com.springlessons.orders.task03;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
@Data
public class Order {
    @MongoId
    private String id;
    private String name;
    List<Product> products;
    private double commonPrice;
    private boolean active;

}
