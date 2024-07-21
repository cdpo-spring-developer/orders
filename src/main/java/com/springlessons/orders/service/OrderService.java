package com.springlessons.orders.service;

import com.springlessons.orders.dto.NewOrderDto;
import com.springlessons.orders.dto.OrderItemDto;
import com.springlessons.orders.model.Order;
import com.springlessons.orders.model.OrderItem;
import com.springlessons.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public void create(NewOrderDto dto) {
        var order = new Order();
        order.setUserId(dto.getUserId());
        var items = new ArrayList<OrderItem>();
        for (OrderItemDto item : dto.getItems()) {
            items.add(new OrderItem(item.getId(), item.getName(), item.getPrice(), item.getCount()));
        }
        order.setItems(items.toArray(OrderItem[] :: new ));
        orderRepository.insert(order);
    }

}
