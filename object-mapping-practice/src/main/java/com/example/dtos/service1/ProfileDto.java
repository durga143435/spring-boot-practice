package com.example.dtos.service1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProfileDto {
    private String firstName;
    private String lastName;

    @JsonProperty("phone_number")
    private String phoneNumber;
    private AddressDto address;
}
