package com.example.unit_test_practice.mappers;

import com.codewithmosh.store.dtos.OrderItemDto;
import com.codewithmosh.store.entities.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemDto toDto(OrderItem orderItem);
}
