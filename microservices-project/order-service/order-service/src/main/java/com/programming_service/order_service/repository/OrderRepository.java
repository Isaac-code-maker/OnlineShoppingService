package com.programming_service.order_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.programming_service.order_service.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional findById(Long id);

    List<Order> findAll();


    void deleteById(Long id);

}
