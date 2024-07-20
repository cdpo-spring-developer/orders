package com.springlessons.orders.task03;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.UUID;

@Document
@Data
public class Order {
    @MongoId
    private UUID id;
    private String name;
    List<ProductDAO> products;
    private double commonPrice;
    private boolean active;

}
