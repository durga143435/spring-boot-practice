package com.example.dtos.combined;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContactResponseDto {
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;


}
