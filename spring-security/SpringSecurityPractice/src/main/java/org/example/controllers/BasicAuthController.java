package org.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bauth/")
public class BasicAuthController {

    @GetMapping("/greetings")
    public String sendGreetings(){
        return "Hello";
    }


}
