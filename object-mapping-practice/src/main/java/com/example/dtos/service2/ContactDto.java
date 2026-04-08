package com.example.dtos.service2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContactDto {
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;


}
