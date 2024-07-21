package com.springlessons.orders.repository;

import com.springlessons.orders.model.Order;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.BodyInserter;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface OrderRepository extends ReactiveMongoRepository<Order, UUID> {

    // Flux<Order> findByUserId(int userId);

    // ? указывает на параметр, 0 - индекс парамера
    // fields - поля, по которым будут извлекаться данные
    @Query(value = "{userId :  ?0}", fields = "{picturesIds: 1, orderedAt:  1}")
    Flux<Order> orderWithUserId(int userId);
    @Query(value = "{items.product_id :  ?0}")
    Flux<Order> findAllByProductId(int productId);
    // sort({userId: -1})
    // find({userId: {$gte: 100, $lte: 300}})
    // find({userId: {$in: [3, 78, 12]}})
    // fields = {picturesIds: {$slice: 5}}
}



