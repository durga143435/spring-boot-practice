package com.example.unit_test_practice.repositories;

import com.codewithmosh.store.entities.Order;
import com.codewithmosh.store.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findAllByOrder(Order order);
}
