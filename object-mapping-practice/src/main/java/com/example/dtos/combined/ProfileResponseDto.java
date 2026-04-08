package com.example.dtos.combined;

import lombok.Data;

@Data
public class ProfileResponseDto {

    private String mobileNumber;
    private AddressResponseDto address;
}
