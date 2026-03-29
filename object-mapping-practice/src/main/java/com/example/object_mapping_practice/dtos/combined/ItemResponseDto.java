package com.example.object_mapping_practice.dtos.combined;

import com.example.object_mapping_practice.dtos.service2.SpecsDto;
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
