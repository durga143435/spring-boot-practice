package com.example.client_credential_manual_token_refresh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "spring.security.oauth2")
public class AuthProps {

    private Map<String, String> authHeaders;
    private String tokenUri;

}
