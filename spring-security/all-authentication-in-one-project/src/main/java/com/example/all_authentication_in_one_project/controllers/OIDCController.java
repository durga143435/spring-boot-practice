package com.example.all_authentication_in_one_project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OIDCController {

    @GetMapping("/oidc/getAuthType")
    public String authType(){
        return "client credential authorization";
    }

    @GetMapping("/oidc/homePage")
    public String greetings(){
        return "User Landed to home page after oidc authentication";
    }

    @GetMapping("/message")
    public String message(){
        return "message from unsecured api from oidc";
    }
}
