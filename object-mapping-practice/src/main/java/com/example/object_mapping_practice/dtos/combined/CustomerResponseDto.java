package com.example.object_mapping_practice.dtos.combined;

import com.example.object_mapping_practice.dtos.service2.ContactDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerResponseDto {
    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("customer_name")
    private String customerName;




}
