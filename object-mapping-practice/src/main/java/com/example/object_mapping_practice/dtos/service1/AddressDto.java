package com.example.object_mapping_practice.dtos.service1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressDto {
    private String street;
    private String city;
    private String state;

    @JsonProperty("postal_code")
    private String postalCode;

}
