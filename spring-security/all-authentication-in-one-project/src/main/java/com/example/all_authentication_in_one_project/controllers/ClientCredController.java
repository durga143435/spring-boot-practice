package com.example.all_authentication_in_one_project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientCredController {

    @GetMapping("/clientcred/getAuthType")
    public String authType(){
        return "client credential authorization";
    }

    @GetMapping("/greetings")
    public String greetings(){
        return "Hello";
    }

}
