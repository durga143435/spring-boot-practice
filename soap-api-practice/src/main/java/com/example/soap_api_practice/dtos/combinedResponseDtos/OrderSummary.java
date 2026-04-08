package com.example.soap_api_practice.dtos.combinedResponseDtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Data;

import java.math.BigDecimal;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderSummary {
    Integer totalCount;
    BigDecimal totalPrice;
}
