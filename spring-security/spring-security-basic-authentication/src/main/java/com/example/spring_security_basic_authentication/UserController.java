package com.example.spring_security_basic_authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/getAuthType")
    public String getAuthType(){
        return "Basic Authentication";
    }

}
