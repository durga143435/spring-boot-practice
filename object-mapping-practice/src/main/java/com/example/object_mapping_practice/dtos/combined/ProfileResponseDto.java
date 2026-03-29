package com.example.object_mapping_practice.dtos.combined;

import com.example.object_mapping_practice.dtos.service1.AddressDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProfileResponseDto {

    private String mobileNumber;
    private AddressResponseDto address;
}
