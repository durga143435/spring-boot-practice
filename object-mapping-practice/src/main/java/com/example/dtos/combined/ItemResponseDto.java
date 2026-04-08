package com.example.dtos.combined;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemResponseDto {
    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("product_name")
    private String itemName;
    private BigDecimal amount;
    private SpecsResponseDto specs;



}
