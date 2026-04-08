package com.example.client_credential_manual_token_refresh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OidcApiController {

    @Autowired
    RestTemplate template;

    @GetMapping("/test/oidc")
    public String login(){
            return template.exchange("http://localhost:8081/oidc/getAuthType", HttpMethod.GET, null, String.class).getBody();
    }


}
