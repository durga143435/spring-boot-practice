package com.example.soap_api_practice.dtos.combinedResponseDtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItem {
    String itemName;
    OrderShipment orderShipment;
}
