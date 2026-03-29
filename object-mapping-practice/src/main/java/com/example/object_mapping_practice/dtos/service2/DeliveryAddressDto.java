package com.example.object_mapping_practice.dtos.service2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeliveryAddressDto {
    private String state;

    @JsonProperty("postal_code")
    private String postal_code;

}
