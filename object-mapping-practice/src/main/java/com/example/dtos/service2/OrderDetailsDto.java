package com.example.dtos.service2;

import com.example.dtos.combined.CustomObj;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class OrderDetailsDto {
    private String orderId;

    @JsonProperty("order_date")
    private String orderDate;

    private CustomerDto customer;

    @JsonProperty("order_status")
    private String orderStatus;

    private Set<ItemDto> items;
    private ShipmentDto shipment;

    private CustomObj customObj;

    private Boolean isActive;

}
