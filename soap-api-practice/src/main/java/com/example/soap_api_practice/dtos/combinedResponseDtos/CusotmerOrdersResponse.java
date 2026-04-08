package com.example.soap_api_practice.dtos.combinedResponseDtos;

import com.example.soap_api_practice.dtos.generatedService1Dtos.Orders;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Data;

import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CusotmerOrdersResponse {
    OrderStatus orderStatus;
    List<PlacedOrder> placedOrders;
}
