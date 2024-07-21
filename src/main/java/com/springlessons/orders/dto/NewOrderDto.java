package com.springlessons.orders.dto;

import com.springlessons.orders.model.Product;
import com.springlessons.orders.model.User;
import lombok.Data;

/*POST: /order - в теле сообщения передаются
        {
        id пользователя
        товары: [
        id товара
        название
        стоимость
        количество
        ]
        }
        сформировать и сохранить заказ в БД*/
@Data
public class NewOrderDto {
    private int userId;

    private OrderItemDto[] items;


}
