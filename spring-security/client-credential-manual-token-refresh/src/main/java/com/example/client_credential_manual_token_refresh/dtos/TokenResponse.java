package com.example.client_credential_manual_token_refresh.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenResponse {
    @JsonProperty("expires_in")
    int expiry;

    @JsonProperty("access_token")
    String accessToken;
}
