package com.example.object_mapping_practice.dtos.service2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemDto {
    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("product_name")
    private String productName;
    private String quantity;
    private BigDecimal price;
    private SpecsDto specs;



}
