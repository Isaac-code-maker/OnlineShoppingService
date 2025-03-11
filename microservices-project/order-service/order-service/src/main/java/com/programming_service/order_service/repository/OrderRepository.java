package com.programming_service.order_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.programming_service.order_service.models.Order;

public interface OrderRepository extends MongoRepository<Order, Long> {
    Optional<Order> findById(String id);

    List<Order> findAll();

    void deleteById(String id);
}
