package com.springlessons.orders.model;


import lombok.NoArgsConstructor;


public record Trader( int traderId,
        String traderName,
        Integer inn)  { }
