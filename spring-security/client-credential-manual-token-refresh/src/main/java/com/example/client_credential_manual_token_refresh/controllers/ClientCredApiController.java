package com.example.client_credential_manual_token_refresh.controllers;

import com.example.client_credential_manual_token_refresh.services.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ClientCredApiController {

    @Autowired
    RestTemplate template;

    @Autowired
    AuthToken authToken;

    @GetMapping("/cc1/authType")
    public String authType(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+authToken.getAccessToken());

        HttpEntity entity = new HttpEntity(headers);

        return template.exchange("http://localhost:8081/clientcred/getAuthType", HttpMethod.GET, entity, String.class).getBody();
    }

}
