package com.example.object_mapping_practice.dtos.combined;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressResponseDto {
    private String city;

    private String pinCode;

}
