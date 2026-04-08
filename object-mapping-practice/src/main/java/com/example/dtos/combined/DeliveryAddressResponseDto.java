package com.example.dtos.combined;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeliveryAddressResponseDto {
    private String street;
    private String city;
    private String state;

    @JsonProperty("postal_code")
    private String postal_code;

}
