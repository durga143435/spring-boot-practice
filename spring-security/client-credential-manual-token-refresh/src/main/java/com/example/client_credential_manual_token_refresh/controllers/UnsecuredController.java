package com.example.client_credential_manual_token_refresh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UnsecuredController {

    @Autowired
    RestTemplate template;

    @GetMapping("/unsecure/m1")
    public String m1() {
        return template.exchange("http://localhost:8081/message", HttpMethod.GET, null, String.class).getBody();
    }

    @GetMapping("/unsecure/m2")
    public String m2() {
        return template.exchange("http://localhost:8081/greetings", HttpMethod.GET, null, String.class).getBody();
    }

}
