package com.example.dtos.service1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class UserAccDetailsDto {
    private String userId;

    @JsonProperty("user_name")
    private String userName;
    private String email;
    private Boolean isActive;
    private ProfileDto profile;
    private Set<AccountDto> accounts;

}
