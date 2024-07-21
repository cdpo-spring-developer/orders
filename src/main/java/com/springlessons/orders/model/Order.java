package com.springlessons.orders.model;


import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.util.UUID;


@Data
@Document("pic_shop_order")
public class Order {
    // уникальный идентификатор записи
    @MongoId
    private UUID id;
    // - похожи на индексы в sql
    // - могут быть составными (но не по всем полям)
    // - хранятся отдельно в упорядоченном виде
    // - не могут создавать связей с другими документами
    // - замедляют вставку данных
    @Indexed
    private int userId;

    private OrderItem[] items;


}
